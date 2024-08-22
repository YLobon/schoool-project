package com.luna.school.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.luna.school.AbstractRessourceIT;
import com.luna.school.TestUtils;
import com.luna.school.entite.EtudiantTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.factory.AnneScolaireFactory;
import com.luna.school.factory.EtudiantFactory;
import com.luna.school.interfaces.rest.EtudiantRessource;
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

public class EtudiantRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/etudiant";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private EtudiantRessource etudiantRessource;
  @Autowired
  EtudiantFactory etudiantFactory;
  @Autowired
  private AnneScolaireFactory anneScolaireFactory;
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(etudiantRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }

  @Test
  void recuperer() throws Exception {
    // Given
    EtudiantTable etudiantTable = this.etudiantFactory.genererEtudiant();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", etudiantTable.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    EtudiantTable etudiantTable = this.etudiantFactory.genererEtudiant();
    EtudiantTable etudiantTable1 = this.etudiantFactory.genererEtudiant1();
    EtudiantTable etudiantTable2 = this.etudiantFactory.genererEtudiant2();
    EtudiantTable etudiantTable3 = this.etudiantFactory.genererEtudiant3();
    EtudiantTable etudiantTable4 = this.etudiantFactory.genererEtudiant4();
    EtudiantTable etudiantTable5 = this.etudiantFactory.genererEtudiant5();
    EtudiantTable etudiantTable6 = this.etudiantFactory.genererEtudiant6();
    EtudiantTable etudiantTable7 = this.etudiantFactory.genererEtudiant7();
    EtudiantTable etudiantTable8 = this.etudiantFactory.genererEtudiant8();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void statistique() throws Exception {
    // Given
    EtudiantTable etudiantTable = this.etudiantFactory.genererEtudiant();
    EtudiantTable etudiantTable1 = this.etudiantFactory.genererEtudiant1();
    EtudiantTable etudiantTable2 = this.etudiantFactory.genererEtudiant2();
    EtudiantTable etudiantTable3 = this.etudiantFactory.genererEtudiant3();
    EtudiantTable etudiantTable4 = this.etudiantFactory.genererEtudiant4();
    EtudiantTable etudiantTable5 = this.etudiantFactory.genererEtudiant5();
    EtudiantTable etudiantTable6 = this.etudiantFactory.genererEtudiant6();
    EtudiantTable etudiantTable7 = this.etudiantFactory.genererEtudiant7();
    EtudiantTable etudiantTable8 = this.etudiantFactory.genererEtudiant8();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/statistique"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  @DisplayName("Test la récupération des trimestres")
  void listerParSexe() throws Exception {
    // Given
    EtudiantTable etudiantTable = this.etudiantFactory.genererEtudiant();
    EtudiantTable etudiantTable1 = this.etudiantFactory.genererEtudiant1();
    EtudiantTable etudiantTable2 = this.etudiantFactory.genererEtudiant2();
    EtudiantTable etudiantTable3 = this.etudiantFactory.genererEtudiant3();
    EtudiantTable etudiantTable4 = this.etudiantFactory.genererEtudiant4();
    EtudiantTable etudiantTable5 = this.etudiantFactory.genererEtudiant5();
    EtudiantTable etudiantTable6 = this.etudiantFactory.genererEtudiant6();
    EtudiantTable etudiantTable7 = this.etudiantFactory.genererEtudiant7();
    EtudiantTable etudiantTable8 = this.etudiantFactory.genererEtudiant8();
    Civilite civilite = etudiantTable.getCivilite();
    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.convertObjectToJsonBytes(Civilite.MONSIEUR))
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print());
    // Then
    mvcResult.andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty());
  }

}
