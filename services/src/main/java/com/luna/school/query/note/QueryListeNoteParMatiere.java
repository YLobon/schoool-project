package com.luna.school.query.note;

import com.luna.school.entite.NoteTable;
import com.luna.school.mapper.NoteMapper;
import com.luna.school.note.application.vm.NoteEssentielVM;
import com.luna.school.repository.JpaNoteRepository;
import com.luna.school.tools.GestionnaireRequetePair;
import com.luna.school.tools.NonTrouveException;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListeNoteParMatiere implements
    GestionnaireRequetePair<List<NoteEssentielVM>, UUID, UUID> {

  private final JpaNoteRepository jpaNoteRepository;
  private final NoteMapper noteMapper;

  public QueryListeNoteParMatiere(JpaNoteRepository jpaNoteRepository) {
    this.jpaNoteRepository = jpaNoteRepository;
    noteMapper = NoteMapper.INSTANCE;
  }

  @Override
  public List<NoteEssentielVM> requete(UUID classeId, UUID matiereId) throws NonTrouveException {
    List<NoteTable> noteTableList = this.jpaNoteRepository
        .findByClasseIdAndMatiereId(classeId, matiereId);
    // Trier par ordre alphabétique des noms complets des étudiants
    return noteTableList.stream()
        .sorted(Comparator.comparing(noteTable -> noteTable.getEtudiant().nomComplet()))
        .map(this.noteMapper::noteTableVersNoteEssentielVM)
        .collect(Collectors.toList());
  }
}
