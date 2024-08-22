package com.luna.school.query.note;

import com.luna.school.entite.NoteTable;
import com.luna.school.mapper.NoteMapper;
import com.luna.school.note.application.vm.NoteEssentielVM;
import com.luna.school.repository.JpaNoteRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListeNote implements GestionnaireRequete<List<NoteEssentielVM>, Void> {

  private final JpaNoteRepository jpaNoteRepository;
  private final NoteMapper noteMapper;

  public QueryListeNote(JpaNoteRepository jpaNoteRepository) {
    this.jpaNoteRepository = jpaNoteRepository;
    this.noteMapper = NoteMapper.INSTANCE;
  }

  @Override
  public List<NoteEssentielVM> requete(Void var1) {
    List<NoteTable> noteTableList = this.jpaNoteRepository.findAll();
    return noteTableList.stream().map(this.noteMapper::noteTableVersNoteEssentielVM)
        .collect(Collectors.toList());
  }
}
