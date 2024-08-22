package com.luna.school.query.note;

import com.luna.school.entite.NoteTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.NoteMapper;
import com.luna.school.note.application.vm.NoteDetailVM;
import com.luna.school.repository.JpaNoteRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryNoteDetail implements GestionnaireRequete<NoteDetailVM, UUID> {

  private final JpaNoteRepository jpaNoteRepository;
  private final NoteMapper noteMapper;

  public QueryNoteDetail(JpaNoteRepository jpaNoteRepository) {
    this.jpaNoteRepository = jpaNoteRepository;
    this.noteMapper = NoteMapper.INSTANCE;
  }

  @Override
  public NoteDetailVM requete(UUID id) {
    Optional<NoteTable> noteTableOptional = this.jpaNoteRepository.findById(id);
    if (noteTableOptional.isPresent()) {
      var matiereTable = noteTableOptional.get();
      var noteDetailsVM = this.noteMapper
          .noteTableVersNoteDetailVM(matiereTable);
      return noteDetailsVM;
    }
    throw new NonTrouveException(
        "La note avec l'identifiant est " + id + " est introuvable !");
  }

}
