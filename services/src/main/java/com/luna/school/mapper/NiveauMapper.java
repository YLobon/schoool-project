
package com.luna.school.mapper;


import com.luna.school.entite.NiveauTable;
import com.luna.school.niveau.application.vm.NiveauDetailsVM;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import com.luna.school.niveau.domaine.entite.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class NiveauMapper {

  public static final NiveauMapper INSTANCE = Mappers.getMapper(NiveauMapper.class);

  public abstract Niveau niveauTableVersNiveau(
      NiveauTable niveauTable);

  public abstract NiveauTable niveauVersNiveauTable(
      Niveau niveau);

  public abstract NiveauDetailsVM niveauTableVersNiveauDetailsVM(NiveauTable niveauTable);
  @Mapping(target = "educateur", expression = "java(niveauTable.getEducateur().nomComplet())")
  public abstract NiveauEssentielVM niveauTableVersNiveauEssentielVM(NiveauTable niveauTable);

}
