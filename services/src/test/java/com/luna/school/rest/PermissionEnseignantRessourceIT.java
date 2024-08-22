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
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.entite.EnseignantTable;
import com.luna.school.entite.PermissionEnseignantTable;
import com.luna.school.factory.EnseignantFactory;
import com.luna.school.factory.PermissionEnseignantFactory;
import com.luna.school.interfaces.rest.PermissionEnseignantRessource;
import com.luna.school.permission.application.commande.CreerPermissionEnseignantCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEnseignantCommande;
import java.time.LocalDate;
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

public class PermissionEnseignantRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/permission-enseignant";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired(required = false)
  private PermissionEnseignantRessource permissionEnseignantRessource;
  @Autowired
  PermissionEnseignantFactory permissionEnseignantFactory;
  @Autowired
  private EnseignantFactory enseignantFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(permissionEnseignantRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    EnseignantTable enseignant = enseignantFactory.enseignant();
    var commande = new CreerPermissionEnseignantCommande();
    commande.setDateDebut(LocalDate.now());
    commande.setDateFin(LocalDate.of(2025,5,18));
    commande.setDescription("première description");
    commande.setEnseignantId(enseignant.getId());
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
    PermissionEnseignantTable permissionEnseignantTable = this.permissionEnseignantFactory.permissionEnseignant();
    UUID id = permissionEnseignantTable.getId();
    var commande = new ModifierPermissionEnseignantCommande();
    EnseignantTable enseignant = enseignantFactory.enseignant();

    commande.setPermissionId(id);
    commande.setDateDebut(LocalDate.now().plusDays(2));
    commande.setDateFin(LocalDate.now().plusMonths(5));
    commande.setDescription("nouvelle description");
    commande.setEnseignantId(enseignant.getId());

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
    PermissionEnseignantTable permissionEnseignantTable = this.permissionEnseignantFactory.permissionEnseignant();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", permissionEnseignantTable.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    PermissionEnseignantTable permissionEnseignantTable = this.permissionEnseignantFactory.permissionEnseignant();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", permissionEnseignantTable.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    PermissionEnseignantTable permissionEnseignantTable = this.permissionEnseignantFactory.permissionEnseignant();
    PermissionEnseignantTable permissionEnseignant = this.permissionEnseignantFactory.permissionEnseignant();
    PermissionEnseignantTable permissionEnseignantTable2 = this.permissionEnseignantFactory.permissionEnseignant();


    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }
}
