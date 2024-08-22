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
import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.PermissionEtudiantTable;
import com.luna.school.factory.EtudiantFactory;
import com.luna.school.factory.PermissionEtudiantFactory;
import com.luna.school.interfaces.rest.PermissionEtudiantRessource;
import com.luna.school.permission.application.commande.CreerPermissionEleveCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEleveCommande;
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

public class PermissionEtudiantRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/permission-etudiant";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired(required = false)
  private PermissionEtudiantRessource permissionEtudiantRessource;
  @Autowired
  PermissionEtudiantFactory permissionEtudiantFactory;
  @Autowired
  private EtudiantFactory etudiantFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(permissionEtudiantRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    EtudiantTable etudiantTable = etudiantFactory.genererEtudiant3();
    var commande = new CreerPermissionEleveCommande();
    commande.setDateDebut(LocalDate.now());
    commande.setDateFin(LocalDate.of(2025,5,18));
    commande.setDescription("première description");
    commande.setEleveId(etudiantTable.getId());
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
    PermissionEtudiantTable permissionEtudiantTable = this.permissionEtudiantFactory.permissionEtudiant();
    UUID id = permissionEtudiantTable.getId();
    var commande = new ModifierPermissionEleveCommande();
    EtudiantTable etudiantTable = etudiantFactory.genererEtudiant2();

    commande.setPermissionId(id);
    commande.setDateDebut(LocalDate.now().plusDays(2));
    commande.setDateFin(LocalDate.now().plusMonths(5));
    commande.setDescription("nouvelle description");
    commande.setEleveId(etudiantTable.getId());

    // When
    var mvcResult = this.mockMvc.perform(put(API_URL+"/modifier")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isOk());
  }

//  @Test
//  void supprimer() throws Exception {
//    // Given
//    PermissionEtudiantTable permissionEtudiantTable = this.permissionEtudiantFactory.permissionEtudiant();
//    // When
//    var mvcResult = this.mockMvc.perform(
//        delete(API_URL + "/supprimer/{id}", permissionEtudiantTable.getId()));
//    // Then
//    mvcResult.andExpect(status().isOk());
//  }

  @Test
  void recuperer() throws Exception {
    // Given
    PermissionEtudiantTable permissionEtudiantTable = this.permissionEtudiantFactory.permissionEtudiant();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", permissionEtudiantTable.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    PermissionEtudiantTable permissionEtudiantTable = this.permissionEtudiantFactory.permissionEtudiant();
    PermissionEtudiantTable permissionEtudiant2 = this.permissionEtudiantFactory.permissionEtudiant();
    PermissionEtudiantTable permissionEtudiant1 = this.permissionEtudiantFactory.permissionEtudiant();


    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }
}
