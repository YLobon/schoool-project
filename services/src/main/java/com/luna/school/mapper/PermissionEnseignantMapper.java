package com.luna.school.mapper;


import com.luna.school.entite.PermissionEnseignantTable;
import com.luna.school.permission.application.vm.PermissionEnseignantVM;
import com.luna.school.permission.domaine.entite.PermissionEnseignant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class PermissionEnseignantMapper {

  public static final PermissionEnseignantMapper INSTANCE = Mappers.getMapper(
      PermissionEnseignantMapper.class);

  public abstract PermissionEnseignant permissionEnseignantTableVersPermissionEnseignant(
      PermissionEnseignantTable permissionEnseignantTable);

  public abstract PermissionEnseignantTable permissionEnseignantVersPermissionEnseignantTable(
      PermissionEnseignant permissionEnseignant);
  @Mapping(target = "enseignant", expression = "java(permissionEnseignantTable.getEnseignant().nomComplet())")
  public abstract PermissionEnseignantVM permissionEnseignantTableVersPermissionEnseignantVM(
      PermissionEnseignantTable permissionEnseignantTable);


}
