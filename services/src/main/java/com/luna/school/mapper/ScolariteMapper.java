package com.luna.school.mapper;


import com.luna.school.comptabilite.application.vm.ScolariteDetailsVM;
import com.luna.school.comptabilite.application.vm.ScolariteEssentielVM;
import com.luna.school.comptabilite.domaine.entite.Scolarite;
import com.luna.school.entite.ScolariteTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class ScolariteMapper {

  public static final ScolariteMapper INSTANCE = Mappers.getMapper(ScolariteMapper.class);

  public abstract Scolarite scolariteTableVersScolarite(
      ScolariteTable scolariteTable);

  public abstract ScolariteTable scolariteVersScolariteTable(
      Scolarite scolarite);

  public abstract ScolariteEssentielVM scolariteTableVersScolariteEssentielVM(
      ScolariteTable scolariteTable);

  public abstract ScolariteDetailsVM scolariteTableVersScolariteDetailsVM(
      ScolariteTable scolariteTable);


}
