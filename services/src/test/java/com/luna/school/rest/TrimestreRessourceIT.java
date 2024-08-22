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
import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.entite.TrimestreTable;
import com.luna.school.factory.AnneScolaireFactory;
import com.luna.school.factory.TrimestreFactory;
import com.luna.school.interfaces.rest.TrimestreRessource;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
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

public class TrimestreRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/trimestre";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private TrimestreRessource trimestreRessource;
  @Autowired
  TrimestreFactory trimestreFactory;
  @Autowired
  private AnneScolaireFactory anneScolaireFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(trimestreRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    AnneeScolaireTable anneeScolaireTable = anneScolaireFactory.anneScolaire();
    UUID anneeScolaireTableId = anneeScolaireTable.getId();
    var commande = new CreerTrimestreCommande();
    commande.setLibelle("2024-2025");
    commande.setDateDebut(LocalDate.now());
    commande.setDateFin(LocalDate.of(2025,5,18));
    commande.setAnneeScolaireId(anneeScolaireTableId);
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
    AnneeScolaireTable anneeScolaireTable = this.anneScolaireFactory.anneScolaire();
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    UUID id = trimestre.getId();
    var commande = new ModifierTrimestreCommande();

    commande.setId(id);
    commande.setLibelle("Trimestre actuel");
    commande.setDateDebut(LocalDate.now());
    commande.setDateFin(LocalDate.of(2025,5,18));
    commande.setAnneeScolaireId(anneeScolaireTable.getId());

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
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", trimestre.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", trimestre.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    TrimestreTable trimestre1 = this.trimestreFactory.trimestre();
    TrimestreTable trimestre2 = this.trimestreFactory.trimestre();

    UUID anneeScolaireTableId = trimestre2.getId();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  @DisplayName("Test la récupération des trimestres")
  void listerAction() throws Exception {
    // Given
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    UUID anneeScolaireId = trimestre.getAnneeScolaire().getId();
    // When
    var mvcResult = this.mockMvc
        .perform(get(API_URL + "/{anneeScolaireId}/annee-scolaire", anneeScolaireId))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty());
  }

}
