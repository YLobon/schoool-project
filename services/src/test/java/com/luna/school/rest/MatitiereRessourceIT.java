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
import com.luna.school.entite.MatiereTable;
import com.luna.school.entite.SousMatiereTable;
import com.luna.school.factory.MatiereFactory;
import com.luna.school.factory.SousMatiereFactory;
import com.luna.school.interfaces.rest.MatiereRessource;
import com.luna.school.matiere.application.commande.AssocierSousMatiereAuMatiereCommande;
import com.luna.school.matiere.application.commande.CreerMatiereCommande;
import com.luna.school.matiere.application.commande.ModifiereMatierCommande;
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
 * @Project school
 * @Author BOUA YVES 2024-05-03 6:59 a.m..
 */

public class MatitiereRessourceIT extends AbstractRessourceIT {

  private final String API_URL = "/api/luna/scolaire/matiere";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private MatiereRessource matiereRessource;
  @Autowired
  private MatiereFactory matiereFactory;
  @Autowired
  private SousMatiereFactory sousMatiereFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(matiereRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    var commande = new CreerMatiereCommande();
    commande.setNom("Mathematique");
    commande.setCoefficient(2);
    commande.setSousMatierePresent(false);
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
    MatiereTable matiere = this.matiereFactory.matiere();
    var commande = new ModifiereMatierCommande();
    commande.setId(matiere.getId());
    commande.setNom("Physique Chimie");
    commande.setSousMatierePresent(false);
    commande.setCoefficient(4);
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
    MatiereTable matiere = this.matiereFactory.matiere();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", matiere.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    MatiereTable matiere = this.matiereFactory.matiere();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", matiere.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    MatiereTable matiere = this.matiereFactory.matiere();
    MatiereTable matiereTable1 = this.matiereFactory.matiereTable();
    MatiereTable matiereTable = this.matiereFactory.matiereFrancais();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void ajouterSousMatiere() throws Exception {
    // Given
    SousMatiereTable sousMatiereTable = sousMatiereFactory.sousMatiere();
    UUID sousMatiereTableId = sousMatiereTable.getId();
    MatiereTable matiere = matiereFactory.matiere();
    UUID matiereId = matiere.getId();
    var commande = new AssocierSousMatiereAuMatiereCommande();
    commande.setMatiereId(matiereId);
    commande.setSousMatiereId(sousMatiereTableId);
    // When
    var mvcResult = this.mockMvc.perform(post(API_URL + "/ajouter")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isCreated());
  }

}
