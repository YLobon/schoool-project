package com.luna.school.mapper;


import com.luna.school.entite.PermissionPersonnelTable;
import com.luna.school.permission.application.vm.PermissionPersonnelVM;
import com.luna.school.permission.domaine.entite.PermissionPersonnel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class PermissionPersonnelMapper {

  public static final PermissionPersonnelMapper INSTANCE = Mappers.getMapper(
      PermissionPersonnelMapper.class);

  public abstract PermissionPersonnel permissionPersonnelTableVersPermissionPersonnel(
      PermissionPersonnelTable permissionPersonnelTable);

  public abstract PermissionPersonnelTable permissionPersonnelVersPermissionPersonnelTable(
      PermissionPersonnel permissionPersonnel);
  @Mapping(target = "personnel", expression = "java(permissionPersonnelTable.getPersonnel().nomComplet())")
  public abstract PermissionPersonnelVM permissionPersonnelTableVersPermissionPersonnelVM(
      PermissionPersonnelTable permissionPersonnelTable);


}
