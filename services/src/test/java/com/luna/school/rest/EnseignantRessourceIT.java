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
import com.luna.school.enseignant.application.commande.CreerEnseignantCommande;
import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import com.luna.school.entite.EnseignantTable;
import com.luna.school.entite.PaysTable;
import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.factory.EnseignantFactory;
import com.luna.school.factory.PaysFactory;
import com.luna.school.factory.TypeEnseignantFactory;
import com.luna.school.interfaces.rest.EnseignantRessource;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * <p> {@link  } .</p>
 *
 * @author BOUA YVES 2024-05-03 6:59 a.m..
 * @Project school
 */

public class EnseignantRessourceIT extends AbstractRessourceIT {

  private final String API_URL = "/api/luna/scolaire/enseignant";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired(required = false)
  private EnseignantRessource enseignantRessource;
  @Autowired
  EnseignantFactory enseignantFactory;
  @Autowired
  private PaysFactory paysFactory;
  @Autowired
  private TypeEnseignantFactory typeEnseignantFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(enseignantRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    PaysTable pays = this.paysFactory.pays();
    TypeEnseignantTable typeEnseignantTable = typeEnseignantFactory.typeEnseignant();

    var commande = new CreerEnseignantCommande();

    commande.setCivilite(Civilite.MONSIEUR);
    commande.setNom("DJONY");
    commande.setPrenoms("BULL");
    commande.setContact("0142804744");
    commande.setMatricule("0049 698");
    commande.setPiece(TypePiece.PASSPORT);
    commande.setNumeroPiece("09 2563 558 09");
    commande.setNumeroEnseignant("021458M");
    commande.setNationnailiteId(pays.getId());
    commande.setSpecialite("Mathematique");
    commande.setResidence("Yopougon");
    commande.setTypeEnseignantId(typeEnseignantTable.getId());
    // When
    var mvcResult = this.mockMvc.perform(post(API_URL + "/creer")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isCreated());
  }

  @Test
  void modifier() throws Exception {
    // Given
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    TypeEnseignantTable typeEnseignantTable = typeEnseignantFactory.typeEnseignant();
    UUID typeEnseignantTableId = typeEnseignantTable.getId();
    UUID id = enseignant.getId();
    PaysTable pays = this.paysFactory.pays();
    var commande = new ModifierEnseignantCommande();
    commande.setId(id);
    commande.setCivilite(Civilite.MONSIEUR);
    commande.setNom("DJONY");
    commande.setPrenoms("BULL");
    commande.setContact("0142804744");
    commande.setMatricule("0049 698");
    commande.setPiece(TypePiece.PASSPORT);
    commande.setNumeroPiece("09 2563 558 09");
    commande.setNationnailiteId(pays.getId());
    commande.setNumeroEnseignant("021458M");
    commande.setSpecialite("Mathematique");
    commande.setResidence("Yopougon");
    commande.setTypeEnseignantId(typeEnseignantTableId);

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
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", enseignant.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", enseignant.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    EnseignantTable enseignant1 = this.enseignantFactory.enseignant();
    EnseignantTable enseignant2 = this.enseignantFactory.enseignant();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }
}
