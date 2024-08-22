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
import com.luna.school.entite.PaysTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.factory.PaysFactory;
import com.luna.school.factory.PersonnelFactory;
import com.luna.school.interfaces.rest.PersonnelRessource;
import com.luna.school.personnel.application.commande.CreerPersonnelCommande;
import com.luna.school.personnel.application.commande.ModifierPersonnelCommande;
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

public class PersonnelRessourceIT extends AbstractRessourceIT {
  private final String API_URL = "/api/luna/scolaire/personnel";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private PersonnelRessource personnelRessource;
  @Autowired
  PaysFactory paysFactory;
  @Autowired
  private PersonnelFactory personnelFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(personnelRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given
    PaysTable pays = this.paysFactory.pays();
    var commande = new CreerPersonnelCommande();
    commande.setCivilite(Civilite.MONSIEUR);
    commande.setFonction("Econome");
    commande.setNom("DJONY");
    commande.setPrenoms("BULL");
    commande.setContact("0142804744");
    commande.setMatricule("0049 698");
    commande.setPiece(TypePiece.PASSPORT);
    commande.setNumeroPiece("09 2563 558 09");
    commande.setNationnailite(pays.getId());
    commande.setResidence("Yopougon");

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
    PaysTable pays = this.paysFactory.pays();
    PersonnelTable personnel = personnelFactory.personnel();
    UUID id = personnel.getId();
    var commande = new ModifierPersonnelCommande();
    commande.setId(id);
    commande.setCivilite(Civilite.MONSIEUR);
    commande.setFonction("Econome");
    commande.setNom("DJONY");
    commande.setPrenoms("BULL");
    commande.setContact("0142804744");
    commande.setMatricule("0052 698");
    commande.setPiece(TypePiece.PASSPORT);
    commande.setNumeroPiece("09 2563 558 09");
    commande.setNationnailite(pays.getId());
    commande.setResidence("Yopougon");

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
    PersonnelTable personnel = this.personnelFactory.personnel();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/supprimer/{id}", personnel.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    PersonnelTable personnel = this.personnelFactory.personnel();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", personnel.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
     this.personnelFactory.personnel();
     this.personnelFactory.personnel();
     this.personnelFactory.personnel();


    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

}
