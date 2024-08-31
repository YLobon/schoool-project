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
import com.luna.school.entite.NiveauTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.factory.NiveauFactory;
import com.luna.school.factory.PersonnelFactory;
import com.luna.school.interfaces.rest.NiveauRessource;
import com.luna.school.niveau.application.commande.CreerNiveauCommande;
import com.luna.school.niveau.application.commande.ModifierNiveauCommande;
import java.math.BigDecimal;
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

public class NiveauRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/niveau";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private NiveauRessource niveauRessource;
  @Autowired
  NiveauFactory niveauFactory;
  @Autowired
  private PersonnelFactory personnelFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(niveauRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    PersonnelTable personnel = personnelFactory.personnel();
    UUID personnelId = personnel.getId();
    var commande = new CreerNiveauCommande();
    commande.setEducateurId(personnelId);
    commande.setNom("Première A");
    commande.setMontantScolarite(BigDecimal.valueOf(300.000));

    // When
    var mvcResult = this.mockMvc.perform(post(API_URL+"/creer")
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
    UUID id = niveau.getId();
    var commande = new ModifierNiveauCommande();
    commande.setId(id);
    commande.setNom("Première AB");
    commande.setEducateurId(niveau.getEducateur().getId());
    commande.setMontantScolarite(BigDecimal.valueOf(200000));

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
    NiveauTable niveau = this.niveauFactory.niveau();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", niveau.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    NiveauTable niveau = this.niveauFactory.niveau();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", niveau.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    NiveauTable niveau = this.niveauFactory.niveau();
    NiveauTable niveau1 = this.niveauFactory.niveau();
    NiveauTable niveau2 = this.niveauFactory.niveau();

    UUID anneeScolaireTableId = niveau.getId();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

}
