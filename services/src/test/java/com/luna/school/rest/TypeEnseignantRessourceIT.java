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
import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.factory.TypeEnseignantFactory;
import com.luna.school.interfaces.rest.TypeEnseignantRessource;
import com.luna.school.typeenseignant.application.commande.CreerTypeEnseignantCommande;
import com.luna.school.typeenseignant.application.commande.ModifierTypeEnseignantCammande;
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

public class TypeEnseignantRessourceIT extends AbstractRessourceIT {

  private final String API_URL = "/api/luna/scolaire/type-enseignant";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired(required = false)
  private TypeEnseignantRessource typeEnseignantRessource;
  @Autowired
  TypeEnseignantFactory typeEnseignantFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(typeEnseignantRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given

    var commande = new CreerTypeEnseignantCommande();
    commande.setLibelle("2024-2025");
    commande.setSalaireParHeure(1500.0);
    commande.setTaxe(0.15);
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
    TypeEnseignantTable typeEnseignantTable = this.typeEnseignantFactory.typeEnseignant();
    UUID id = typeEnseignantTable.getId();
    var commande = new ModifierTypeEnseignantCammande();

    commande.setId(id);
    commande.setLibelle("L'année de maintenant");
    commande.setSalaireParHeure(2000);
    commande.setTaxe(0.18);

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
    TypeEnseignantTable typeEnseignantTable = this.typeEnseignantFactory.typeEnseignant();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", typeEnseignantTable.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    TypeEnseignantTable typeEnseignantTable = this.typeEnseignantFactory.typeEnseignant();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", typeEnseignantTable.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    TypeEnseignantTable typeEnseignantTable = this.typeEnseignantFactory.typeEnseignant();
    TypeEnseignantTable typeEnseignantTable1 = this.typeEnseignantFactory.typeEnseignant1();
    TypeEnseignantTable typeEnseignantTable2 = this.typeEnseignantFactory.typeEnseignant2();
    TypeEnseignantTable typeEnseignantTable3 = this.typeEnseignantFactory.typeEnseignant3();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }
}
