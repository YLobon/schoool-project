package com.luna.school.note.application.port;

import com.luna.school.note.application.vm.NoteEssentielVM;
import com.luna.school.note.domaine.entite.Note;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface NoteRepositoryPort {

  void enregistrer(Note note);

  Note recupereParId(UUID id);

  List<NoteEssentielVM> listerParMatiereDeClasse(UUID classeId, UUID matiereId);
}
