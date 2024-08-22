
package com.luna.school.mapper;


import com.luna.school.entite.NoteTable;
import com.luna.school.note.application.vm.NoteDetailVM;
import com.luna.school.note.application.vm.NoteEssentielVM;
import com.luna.school.note.domaine.entite.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class NoteMapper {

  public static final NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

  public abstract Note noteTableVersNote(
      NoteTable noteTable);

  public abstract NoteTable noteVersNoteTable(Note note);

  public abstract NoteDetailVM noteTableVersNoteDetailVM(NoteTable noteTable);

  @Mapping(target = "etudiant", expression = "java(noteTable.getEtudiant().nomComplet())")
  @Mapping(target = "classe", expression = "java(noteTable.getClasse().getLibelle())")
  @Mapping(target = "matiere", expression = "java(noteTable.getMatiere().getNom())")
  public abstract NoteEssentielVM noteTableVersNoteEssentielVM(
      NoteTable noteTable);

}
