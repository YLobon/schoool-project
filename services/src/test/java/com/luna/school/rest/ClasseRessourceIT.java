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
import com.luna.school.classe.application.commande.CreerClasseCommande;
import com.luna.school.classe.application.commande.ModifierClasseCommande;
import com.luna.school.classe.domaine.objetvaleur.Cycle;
import com.luna.school.entite.ClasseTable;
import com.luna.school.entite.NiveauTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.entite.SerieTable;
import com.luna.school.factory.AnneScolaireFactory;
import com.luna.school.factory.ClasseFactory;
import com.luna.school.factory.NiveauFactory;
import com.luna.school.factory.PersonnelFactory;
import com.luna.school.factory.SerieFactory;
import com.luna.school.interfaces.rest.ClasseRessource;
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

public class ClasseRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/classe";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private ClasseRessource classeRessource;
  @Autowired
  private SerieFactory serieFactory;
  @Autowired
  private NiveauFactory niveauFactory;
  @Autowired
  private PersonnelFactory personnelFactory;
  @Autowired
  private AnneScolaireFactory anneScolaireFactory;
  @Autowired
  private ClasseFactory classeFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(classeRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    NiveauTable niveau = this.niveauFactory.niveau();
    SerieTable serie = this.serieFactory.serie();
    UUID serieId = serie.getId();
    PersonnelTable personnel = this.personnelFactory.personnel();
    var commande = new CreerClasseCommande();
    commande.setLibelle("6eme6");
    commande.setCycle(Cycle.DEUXIEMECYCLE);
    commande.setSerieId(serieId);
    commande.setProfesseurPrincipalId(personnel.getId());
    commande.setNiveauId(niveau.getId());
    // When
    var mvcResult = this.mockMvc.perform(post(API_URL+"/payer")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isCreated());
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
    var mvcResult = this.mockMvc.perform(put(API_URL+"/modifier")
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
