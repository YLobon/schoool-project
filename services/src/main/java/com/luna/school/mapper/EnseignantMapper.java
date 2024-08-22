package com.luna.school.mapper;


import com.luna.school.enseignant.application.vm.EnseignantDetailsVM;
import com.luna.school.enseignant.application.vm.EnseignantEssentielVM;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.entite.EnseignantTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class EnseignantMapper {

  public static final EnseignantMapper INSTANCE = Mappers.getMapper(EnseignantMapper.class);

  public abstract Enseignant enseignantTableVersEnseignant(
      EnseignantTable enseignantTable);

  public abstract EnseignantTable enseignantVersEnseignantTable(
      Enseignant enseignant);

  public abstract EnseignantEssentielVM enseignantTableVersEnseignantEssentielVM(
      EnseignantTable enseignantTable);

  public abstract EnseignantDetailsVM enseignantTableVersEnseignantDetailsVM(
      EnseignantTable enseignantTable);


}
