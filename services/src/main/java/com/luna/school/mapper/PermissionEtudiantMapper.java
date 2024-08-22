package com.luna.school.mapper;


import com.luna.school.entite.PermissionEtudiantTable;
import com.luna.school.permission.application.vm.PermissionEtudiantVM;
import com.luna.school.permission.domaine.entite.PermissionApprenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class PermissionEtudiantMapper {

  public static final PermissionEtudiantMapper INSTANCE = Mappers.getMapper(
      PermissionEtudiantMapper.class);

  public abstract PermissionApprenant permissionEtudiantTableVersPermissionApprenant(
      PermissionEtudiantTable permissionEtudiantTable);

  public abstract PermissionEtudiantTable permissionApprenantVersPermissionEtudiantTable(
      PermissionApprenant permissionApprenant);
  @Mapping(target = "etudiant", expression = "java(permissionEtudiantTable.getEtudiant().nomComplet())")
  @Mapping(target = "age", expression = "java(permissionEtudiantTable.getEtudiant().calculerAge())")
  public abstract PermissionEtudiantVM permissionEtudiantTableVersPermissionEtudiantVM(
      PermissionEtudiantTable permissionEtudiantTable);


}
