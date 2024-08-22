package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.interfaces.facade.usecase.NoteUseCaseFacade;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.note.application.commande.CreerNoteCommande;
import com.luna.school.note.application.commande.ModifierNoteCommande;
import com.luna.school.note.application.gestionnairecommande.GestionnaireCreerNoteCommande;
import com.luna.school.note.application.gestionnairecommande.GestionnaireModifierNoteCommande;
import com.luna.school.note.application.port.NoteRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 7:37 a.m..
 */
@Service
public class NoteUseCaseFacadeImpl implements NoteUseCaseFacade {

  private final GestionnaireCommande<CreerNoteCommande> creerGestionnaireCommande;
  private final GestionnaireCommande<ModifierNoteCommande> modifierGestionnaireCommande;


  public NoteUseCaseFacadeImpl(ClasseRepositoryPort classeRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort,
      TrimestreRepositoryPort trimestreRepositoryPort, NoteRepositoryPort noteRepositoryPort,
      MatiereRepositoryPort matiereRepositoryPort) {
    this.creerGestionnaireCommande = new GestionnaireCreerNoteCommande(classeRepositoryPort,
        etudiantRepositoryPort, enseignantRepositoryPort, trimestreRepositoryPort,
        noteRepositoryPort, matiereRepositoryPort);
    this.modifierGestionnaireCommande = new GestionnaireModifierNoteCommande(classeRepositoryPort,
        etudiantRepositoryPort, enseignantRepositoryPort, trimestreRepositoryPort,
        noteRepositoryPort, matiereRepositoryPort);
  }

  @Override
  public void creer(CreerNoteCommande commande) {
    this.creerGestionnaireCommande.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {

  }

  @Override
  public void modifier(ModifierNoteCommande commande) {
    this.modifierGestionnaireCommande.execute(commande);
  }




}
