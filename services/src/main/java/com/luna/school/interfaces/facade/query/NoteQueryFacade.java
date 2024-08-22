package com.luna.school.interfaces.facade.query;


import com.luna.school.interfaces.dto.NoteParMatiereVM;
import com.luna.school.note.application.vm.NoteDetailVM;
import com.luna.school.note.application.vm.NoteEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface NoteQueryFacade {

  List<NoteEssentielVM> lister();

  NoteDetailVM recupererParId(UUID id);

  List<NoteEssentielVM> listerParMatiereIdClasse(UUID classeId,UUID matiereId);
  List<NoteParMatiereVM> listNoteParMatiereId(UUID classeId);


}
