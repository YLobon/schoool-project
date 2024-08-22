package com.luna.school.note.application.gestionnairecommande;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.note.application.casutilisation.ModifierNote;
import com.luna.school.note.application.commande.ModifierNoteCommande;
import com.luna.school.note.application.port.NoteRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireModifierNoteCommande implements GestionnaireCommande<ModifierNoteCommande> {

  private final ModifierNote modifierNote;

  public GestionnaireModifierNoteCommande(ClasseRepositoryPort classeRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort,
      TrimestreRepositoryPort trimestreRepositoryPort, NoteRepositoryPort noteRepositoryPort,
      MatiereRepositoryPort matiereRepositoryPort) {
    this.modifierNote = new ModifierNote(classeRepositoryPort, etudiantRepositoryPort,
        enseignantRepositoryPort, trimestreRepositoryPort, noteRepositoryPort,matiereRepositoryPort);
  }

  @Override
  public void execute(ModifierNoteCommande commande) {
    this.modifierNote.modifier(commande);
  }
}
