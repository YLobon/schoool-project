
package com.luna.school.mapper;


import com.luna.school.entite.TrimestreTable;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class TrimestreMapper {

  public static final TrimestreMapper INSTANCE = Mappers.getMapper(TrimestreMapper.class);

  public abstract Trimestre trimestreTableVersTrimestre(
      TrimestreTable trimestreTable);

  public abstract TrimestreTable trimestreeVersTrimestreTable(
      Trimestre trimestre);

  public abstract TrimestreEssentielVM trimestreTableVersTrimestreEssentielVM(
      TrimestreTable trimestreTable);

  public abstract TrimestreDetailVM trimestreTableTAbleVersTrimestreDetailVM(
      TrimestreTable trimestreTable);

}
