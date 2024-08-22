package com.luna.school.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.luna.school.AbstractRessourceIT;
import com.luna.school.TestUtils;
import com.luna.school.entite.ClasseTable;
import com.luna.school.entite.EnseignantTable;
import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.MatiereTable;
import com.luna.school.entite.NoteTable;
import com.luna.school.entite.TrimestreTable;
import com.luna.school.factory.AnneScolaireFactory;
import com.luna.school.factory.ClasseFactory;
import com.luna.school.factory.EnseignantFactory;
import com.luna.school.factory.EtudiantFactory;
import com.luna.school.factory.MatiereFactory;
import com.luna.school.factory.NiveauFactory;
import com.luna.school.factory.NoteFactory;
import com.luna.school.factory.SerieFactory;
import com.luna.school.factory.TrimestreFactory;
import com.luna.school.interfaces.rest.NoteRessource;
import com.luna.school.note.application.commande.CreerNoteCommande;
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

public class NoteRessourceIT extends AbstractRessourceIT {

  private final String API_URL = "/api/luna/scolaire/note";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired
  private NoteRessource noteRessource;
  @Autowired
  private SerieFactory serieFactory;
  @Autowired
  private NiveauFactory niveauFactory;
  @Autowired
  private EnseignantFactory enseignantFactory;
  @Autowired
  private EtudiantFactory etudiantFactory;
  @Autowired
  private AnneScolaireFactory anneScolaireFactory;
  @Autowired
  private ClasseFactory classeFactory;
  @Autowired
  private TrimestreFactory trimestreFactory;
  @Autowired
  private MatiereFactory matiereFactory;
  @Autowired
  NoteFactory noteFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(noteRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given

    ClasseTable classe = classeFactory.classe();
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    TrimestreTable trimestre = trimestreFactory.trimestre();
    MatiereTable matiere = this.matiereFactory.matiere();
    EtudiantTable etudiantTable = etudiantFactory.genererEtudiant();
    var commande = new CreerNoteCommande();
    commande.setNote(15.05);
    commande.setBareme(20.00);
    commande.setEtudiantId(etudiantTable.getId());
    commande.setClasseId(classe.getId());
    commande.setTrimestreId(trimestre.getId());
    commande.setEnseignantId(enseignant.getId());
    commande.setMatiereId(matiere.getId());
    // When
    var mvcResult = this.mockMvc.perform(post(API_URL + "/creer")
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isCreated());
  }

//  @Test
//  void modifier() throws Exception {
//    // Given
//    ClasseTable classe = classeFactory.classe();
//    EnseignantTable enseignant = this.enseignantFactory.enseignant();
//    TrimestreTable trimestre = trimestreFactory.trimestre();
//    MatiereTable matiere = this.matiereFactory.matiere();
//    EtudiantTable etudiantTable = etudiantFactory.genererEtudiant();
//    var commande = new ModifierNoteCommande();
//    commande.setNote(15.05);
//    commande.setBareme(20.00);
//    commande.setEtudiantId(etudiantTable.getId());
//    commande.setClasseId(classe.getId());
//    commande.setTrimestreId(trimestre.getId());
//    commande.setEnseignantId(enseignant.getId());
//    commande.setMatiereId(matiere.getId());
//
//    // When
//    var mvcResult = this.mockMvc.perform(put(API_URL+"/modifier")
//        .accept(MediaType.APPLICATION_JSON_VALUE)
//        .content(TestUtils.convertObjectToJsonBytes(commande))
//        .contentType(MediaType.APPLICATION_JSON)).andDo(print());
//
//    // Then
//    mvcResult.andExpect(status().isOk());
//  }
//
//  @Test
//  void supprimer() throws Exception {
//    // Given
//    ClasseTable classe = this.classeFactory.classe();
//    // When
//    var mvcResult = this.mockMvc.perform(
//        delete(API_URL + "/supprimer/{id}", classe.getId()));
//    // Then
//    mvcResult.andExpect(status().isOk());
//  }

  @Test
  @DisplayName("Test la récupération de Note")
  void recuperer() throws Exception {
    // Given
    NoteTable note = this.noteFactory.note();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", note.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  @DisplayName("Test la récupération des Notes par Matiere")
  void lister() throws Exception {
    // Given

    NoteTable note = this.noteFactory.note();
    NoteTable note1 = this.noteFactory.notes();
    NoteTable note3 = this.noteFactory.notess();
    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  @DisplayName("Test la récupération des Notes par Matiere")
  void listerNote() throws Exception {
    // Given
    NoteTable note = noteFactory.note();
    UUID matiereId = note.getMatiere().getId();

    // When
    var mvcResult = this.mockMvc
        .perform(get(API_URL + "/{classeId}/classe", matiereId))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty());
  }

//  @Test
//  @DisplayName("Test la récupération des Notes par Matiere")
//  void listerNoteDesMatiere() throws Exception {
//    // Given
//    NoteTable note = noteFactory.note();
//    UUID matiereId = note.getMatiere().getId();
//    UUID classeId = note.getClasse().getId();
//
//    // When
//    var mvcResult = this.mockMvc
//        .perform(get(API_URL + "/classe/{classeId}/matiere/{matiereId}", classeId,matiereId))
//        .andDo(print());
//
//    // Then
//    mvcResult.andExpect(status().isOk())
//        .andExpect(jsonPath("$").isNotEmpty());
//  }


  @Test
  @DisplayName("Test la récupération des Notes par Matiere")
  void moyenne() throws Exception {
    // Given

    NoteTable note = this.noteFactory.note();
    NoteTable note1 = this.noteFactory.notes();
    NoteTable note3 = this.noteFactory.notess();
    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/moyenne"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  @DisplayName("Test la récupération des Notes par Matiere")
  void rang() throws Exception {
    // Given

    NoteTable note = this.noteFactory.note();
    NoteTable note1 = this.noteFactory.notes();
    NoteTable note3 = this.noteFactory.notess();
    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/rang"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

}
