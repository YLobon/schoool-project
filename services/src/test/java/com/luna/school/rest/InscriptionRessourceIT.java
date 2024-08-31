package com.luna.school.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.luna.school.AbstractRessourceIT;
import com.luna.school.TestUtils;
import com.luna.school.classe.application.commande.ModifierClasseCommande;
import com.luna.school.entite.ClasseTable;
import com.luna.school.entite.MatiereTable;
import com.luna.school.entite.NiveauTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.entite.SerieTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.Statut;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.etudiant.application.gestionnairecommande.CreerEtudiantCommende;
import com.luna.school.etudiant.application.gestionnairecommande.CreerParentMereEtudiantCommande;
import com.luna.school.etudiant.application.gestionnairecommande.CreerPereEtudiantCommande;
import com.luna.school.etudiant.application.gestionnairecommande.CreerTuTeurEtudiantCommande;
import com.luna.school.etudiant.domaine.objetvaleur.DecisionFinAnnee;
import com.luna.school.factory.AnneScolaireFactory;
import com.luna.school.factory.ClasseFactory;
import com.luna.school.factory.MatiereFactory;
import com.luna.school.factory.NiveauFactory;
import com.luna.school.factory.PaysFactory;
import com.luna.school.factory.PersonnelFactory;
import com.luna.school.factory.SerieFactory;
import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.interfaces.rest.InscriptionRessource;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.pays.domaine.entite.Pays;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-03 6:59 a.m..
 */

public class InscriptionRessourceIT extends AbstractRessourceIT {

  private final String API_URL = "/api/luna/scolaire/inscription";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private InscriptionRessource inscriptionRessource;
  @Autowired
  private SerieFactory serieFactory;
  @Autowired
  private PaysFactory paysFactory;
  @Autowired
  private NiveauFactory niveauFactory;
  @Autowired
  private PersonnelFactory personnelFactory;
  @Autowired
  private AnneScolaireFactory anneScolaireFactory;
  @Autowired
  private MatiereFactory matiereFactory;
  @Autowired
  private ClasseFactory classeFactory;
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(inscriptionRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    MatiereTable matiere = this.matiereFactory.matiere();
    var creerEtudiantCommende = this.genererCreerEtudiantCommande();
    var commande = new CreerInscriptionCommande();
    commande.setIdMatiereFacultatif(matiere.getId());
    commande.setBoursier(true);
    commande.setDateInscription(LocalDate.now());
    commande.setDatePaiement(LocalDate.of(2024,5,8));
    commande.setDroitInscription(true);
    commande.setDeposerPhoto(true);
    commande.setClasseActuelleId(this.classeFactory.classe().getId());
    commande.setCreerEtudiantCommende(creerEtudiantCommende);
    commande.setClassePrecedanteId(this.classeFactory.classe().getId());
    commande.setDecisionFinAnnee(DecisionFinAnnee.ADMIS);
    commande.setEtablissementPrecedante("College Fodoua");
    commande.setFairePremierVersement(true);
    commande.setMontantVerset(BigDecimal.valueOf(120_000));
    commande.setNumeroExtraitNaissance(".011254");
    commande.setExtraitNaisaance(true);
    commande.setRedouble(false);
    commande.setReleveNote(true);

    // When
    var mvcResult = this.mockMvc.perform(post(API_URL + "/creer")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isCreated());
  }

  private CreerEtudiantCommende genererCreerEtudiantCommande() {
    Pays pays = this.paysFactory.transformePaysTable();
    var commande = new CreerEtudiantCommende();
    commande.setCivilite(Civilite.MONSIEUR);
    commande.setNom("Marcelin");
    commande.setStatut(Statut.AFFECTER);
    commande.setPrenoms("Michel");
    commande.setContact("0142804744");
    commande.setMatricule("0048 698");
    commande.setBoursier(true);
    commande.setNationnailite(pays);
    commande.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    commande.setDateNaissance(LocalDate.of(2002, 12, 6));
    commande.setOrphelinDesDePere(false);
    commande.setOrphelinDeMere(false);
    commande.setOrphelinDesDeuxParent(false);
    commande.setLieuNaissance("Man");
    commande.setResidence("Domoraud");
    commande.setParentMereCommande(this.genererMereCommande());
    commande.setParentPereCommande(this.genererPereCommande());
    commande.setTuTeurEtudiantCommande(this.genererTuteurCommande());
    return commande;
  }

  private CreerPereEtudiantCommande genererPereCommande() {
    Pays pays = this.paysFactory.transformePaysTable();
    var commande = new CreerPereEtudiantCommande();
    commande.setCivilite(Civilite.MONSIEUR);
    commande.setNumeroPiece("0021548 M");
    commande.setNom("BOUA");
    commande.setPrenoms("Boua");
    commande.setContact("02014563");
    commande.setFonction("Millitaire");
    commande.setPiece(TypePiece.CNI);
    commande.setNumeroPiece("09 235 441C");
    commande.setResidence("Gbatson");
    commande.setNationnailite(pays);
    return commande;
  }

  private CreerTuTeurEtudiantCommande genererTuteurCommande() {
    Pays pays = this.paysFactory.transformePaysTable();
    var commande = new CreerTuTeurEtudiantCommande();
    commande.setCivilite(Civilite.MONSIEUR);
    commande.setNumeroPiece("tuteur Moise");
    commande.setPrenoms("Benoit");
    commande.setContact("02014563");
    commande.setFonction("Gendarme");
    commande.setNumeroPiece("09 235 441C");
    commande.setNationnailite(pays);
    return commande;
  }

  private CreerParentMereEtudiantCommande genererMereCommande() {
    Pays pays = this.paysFactory.transformePaysTable();
    var commmande = new CreerParentMereEtudiantCommande();
    commmande.setCivilite(Civilite.MADAME);
    commmande.setNumeroPiece("Tiemoko");
    commmande.setPrenoms("Becendine");
    commmande.setContact("0151773886");
    commmande.setFonction("Menagere");
    commmande.setNumeroPiece("09 235 441C");
    commmande.setNationnailite(pays);
    return commmande;
  }

  @Test
  void modifier() throws Exception {
    // Given
    NiveauTable niveau = this.niveauFactory.niveau();
    SerieTable serie = this.serieFactory.serie();
    UUID serieId = serie.getId();
    PersonnelTable personnel = this.personnelFactory.personnel();
    ClasseTable classe = this.classeFactory.classe();
    var commande = new ModifierClasseCommande();
    commande.setClasseId(classe.getId());
    commande.setLibelle("6eme");
    commande.setSerieId(serieId);
    commande.setProfesseurPrincipalId(personnel.getId());
    commande.setNiveauId(niveau.getId());

    // When
    var mvcResult = this.mockMvc.perform(put(API_URL + "/modifier")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void supprimer() throws Exception {
    // Given
    ClasseTable classe = this.classeFactory.classe();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", classe.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    ClasseTable classe = this.classeFactory.classe();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", classe.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    ClasseTable classe = this.classeFactory.classe();
    ClasseTable classes = this.classeFactory.classe();
    ClasseTable classess = this.classeFactory.classe();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  @DisplayName("Test la récupération des Classes")
  void listerClasses() throws Exception {
    // Given
    ClasseTable classe = this.classeFactory.classe();
    UUID niveauId = classe.getNiveau().getId();
    // When
    var mvcResult = this.mockMvc
        .perform(get(API_URL + "/{niveauId}/niveau", niveauId))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty());
  }

}
