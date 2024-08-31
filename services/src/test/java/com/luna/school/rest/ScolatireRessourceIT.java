package com.luna.school.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.luna.school.AbstractRessourceIT;
import com.luna.school.TestUtils;
import com.luna.school.comptabilite.application.commande.PayerScolariteCommande;
import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.InscriptionTable;
import com.luna.school.entite.ScolariteTable;
import com.luna.school.factory.EtudiantFactory;
import com.luna.school.factory.InscriptionFactory;
import com.luna.school.factory.ScolariteFactory;
import com.luna.school.interfaces.rest.ScolariteRessource;
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

public class ScolatireRessourceIT extends AbstractRessourceIT {

  private final String API_URL = "/api/luna/scolaire/scolarite";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private ScolariteFactory scolariteFactory;
  @Autowired
  private ScolariteRessource scolariteRessource;
  @Autowired
  private EtudiantFactory etudiantFactory;
  @Autowired
  private InscriptionFactory inscriptionFactory;
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(scolariteRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void payer() throws Exception {
    // Given
    InscriptionTable inscription = this.inscriptionFactory.inscription();
    UUID etudiantId = inscription.getEtudiant().getId();
    EtudiantTable etudiant = this.etudiantFactory.genererEtudiant();
    var commande = new PayerScolariteCommande();
    commande.setLibelle("Premier versement");
    commande.setDatePaiement(LocalDate.now());
    commande.setEtudiantId(etudiantId);
    commande.setMontantVerset(BigDecimal.valueOf(60_000.0));
    // When
    var mvcResult = this.mockMvc.perform(post(API_URL + "/creer-scolarite")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isCreated());
  }

  @Test
  void supprimer() throws Exception {
    // Given
    ScolariteTable scolarite = this.scolariteFactory.scolarite();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", scolarite.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    ScolariteTable scolarite = this.scolariteFactory.scolarite();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", scolarite.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given

    ScolariteTable scolarite = this.scolariteFactory.scolarite();
    ScolariteTable scolarite1 = this.scolariteFactory.scolarite();
    ScolariteTable scolarite2 = this.scolariteFactory.scolarite();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  @DisplayName("Test la récupération des scolarités par etudiant")
  void listerParEtudiant() throws Exception {
    // Given
    ScolariteTable scolarite = this.scolariteFactory.scolarite();
    UUID etudiantId = scolarite.getEtudiant().getId();
    // When
    var mvcResult = this.mockMvc
        .perform(get(API_URL + "/{etudiantId}/scolarite", etudiantId))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty());
  }

}
