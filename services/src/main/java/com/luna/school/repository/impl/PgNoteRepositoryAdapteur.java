package com.luna.school.repository.impl;

import com.luna.school.entite.NoteTable;
import com.luna.school.mapper.NoteMapper;
import com.luna.school.note.application.port.NoteRepositoryPort;
import com.luna.school.note.application.vm.NoteEssentielVM;
import com.luna.school.note.domaine.entite.Note;
import com.luna.school.note.domaine.exception.NoteException;
import com.luna.school.repository.JpaNoteRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-09 10:18 p.m..
 */
@Repository
public class PgNoteRepositoryAdapteur implements NoteRepositoryPort {
private final JpaNoteRepository jpaNoteRepository;
private final NoteMapper noteMapper;

  public PgNoteRepositoryAdapteur(JpaNoteRepository jpaNoteRepository) {
    this.jpaNoteRepository = jpaNoteRepository;
    noteMapper = NoteMapper.INSTANCE;
  }

  @Override
  public void enregistrer(Note note) {
    NoteTable noteTable = this.noteMapper.noteVersNoteTable(note);
    this.jpaNoteRepository.save(noteTable);
  }

  @Override
  public Note recupereParId(UUID id) {
    Optional<NoteTable> optionalNoteTable = this.jpaNoteRepository.findById(id);
    if(optionalNoteTable.isPresent()){
      return this.noteMapper.noteTableVersNote(optionalNoteTable.get());
    }else {
      throw new NoteException("Cette note est introuvable !");
    }
  }

  @Override
  public List<NoteEssentielVM> listerParMatiereDeClasse(UUID classeId, UUID matiereId) {
    List<NoteTable> noteTableList = this.jpaNoteRepository
        .findByClasseIdAndMatiereId(classeId, matiereId);
    // Trier par ordre alphabétique des noms complets des étudiants
    return noteTableList.stream()
        .sorted(Comparator.comparing(noteTable -> noteTable.getEtudiant().nomComplet()))
        .map(this.noteMapper::noteTableVersNoteEssentielVM)
        .collect(Collectors.toList());
  }
}
