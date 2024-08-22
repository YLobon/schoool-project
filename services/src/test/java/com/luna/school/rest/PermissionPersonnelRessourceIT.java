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
import com.luna.school.entite.PermissionPersonnelTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.factory.PermissionPersonnelFactory;
import com.luna.school.factory.PersonnelFactory;
import com.luna.school.interfaces.rest.PermissionPersonnelRessource;
import com.luna.school.permission.application.commande.CreerPermissionPersonnelCommande;
import com.luna.school.permission.application.commande.ModifierPermissionPersonnelCommande;
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

public class PermissionPersonnelRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/permission-personnel";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired(required = false)
  private PermissionPersonnelRessource permissionPersonnelRessource;
  @Autowired
  PermissionPersonnelFactory permissionPersonnelFactory;
  @Autowired
  private PersonnelFactory personnelFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(permissionPersonnelRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    PersonnelTable personnel = personnelFactory.personnel();
    var commande = new CreerPermissionPersonnelCommande();
    commande.setDateDebut(LocalDate.now());
    commande.setDateFin(LocalDate.of(2025,5,18));
    commande.setDescription("première description");
    commande.setPersonnelId(personnel.getId());
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
    PermissionPersonnelTable permissionPersonnelTable = this.permissionPersonnelFactory.permissionPersonnel();
    UUID id = permissionPersonnelTable.getId();
    PersonnelTable personnel = personnelFactory.personnel();
    var commande = new ModifierPermissionPersonnelCommande();
    commande.setPermissionId(id);
    commande.setDateDebut(LocalDate.now().plusDays(2));
    commande.setDateFin(LocalDate.now().plusMonths(5));
    commande.setDescription("nouvelle description");
    commande.setPersonnelId(personnel.getId());

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
    PermissionPersonnelTable permissionPersonnelTable = this.permissionPersonnelFactory.permissionPersonnel();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", permissionPersonnelTable.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    PermissionPersonnelTable permissionPersonnelTable = this.permissionPersonnelFactory.permissionPersonnel();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", permissionPersonnelTable.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    PermissionPersonnelTable permissionPersonnelTable = this.permissionPersonnelFactory.permissionPersonnel();
    PermissionPersonnelTable permissionPersonnel = this.permissionPersonnelFactory.permissionPersonnel();
    PermissionPersonnelTable permissionPersonne = this.permissionPersonnelFactory.permissionPersonnel();


    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }
}
