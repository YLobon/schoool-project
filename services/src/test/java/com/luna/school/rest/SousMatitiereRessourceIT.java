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
import com.luna.school.entite.SousMatiereTable;
import com.luna.school.factory.SousMatiereFactory;
import com.luna.school.interfaces.rest.SousMatiereRessource;
import com.luna.school.matiere.application.commande.CreerSousMatiereComande;
import com.luna.school.matiere.application.commande.ModifierSousMatierCommande;
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

public class SousMatitiereRessourceIT extends AbstractRessourceIT {

  private final String API_URL = "/api/luna/scolaire/sous-matiere";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private SousMatiereRessource sousMatiereRessource;
  @Autowired
  private SousMatiereFactory sousMatiereFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(sousMatiereRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    var commande = new CreerSousMatiereComande();
    commande.setNomSousMatiere("expression Oral");
    commande.setNote(2);
    commande.setCoefficient(2);
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
    SousMatiereTable sousMatiereTable = this.sousMatiereFactory.sousMatiere();
    var commande = new ModifierSousMatierCommande();
    commande.setId(sousMatiereTable.getId());
    commande.setNomSousMatiere("expression");
    commande.setNote(5);
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
    SousMatiereTable sousMatiereTable = this.sousMatiereFactory.sousMatiere();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", sousMatiereTable.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    SousMatiereTable sousMatiereTable = this.sousMatiereFactory.sousMatiere();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", sousMatiereTable.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    SousMatiereTable sousMatiereTable = this.sousMatiereFactory.sousMatiere();
    SousMatiereTable sousMatiereTable1 = this.sousMatiereFactory.sousMatiere();
    SousMatiereTable sousMatiereTable2 = this.sousMatiereFactory.sousMatiere();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

}
