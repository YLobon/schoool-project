package com.luna.school.mapper;


import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantDatailsVM;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantEssentielVM;
import com.luna.school.typeenseignant.domaine.entite.TypeEnseignant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class TypeEnseignantMapper {

  public static final TypeEnseignantMapper INSTANCE = Mappers.getMapper(TypeEnseignantMapper.class);

  public abstract TypeEnseignant typeEnseignantTableVersTypeEnseignant(
      TypeEnseignantTable typeEnseignantTable);

  public abstract TypeEnseignantTable typeEnseignantVersTypeEnseignantTable(
      TypeEnseignant typeEnseignant);

  public abstract TypeEnseignantEssentielVM typeEnseignantTableVersTypeEnseignantEssentielVM(
      TypeEnseignantTable typeEnseignantTable);

  public abstract TypeEnseignantDatailsVM typeEnseignantTableVersTypeEnseignantDatailsVM(
      TypeEnseignantTable typeEnseignantTable);


}
