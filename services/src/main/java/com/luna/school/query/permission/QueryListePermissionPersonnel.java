package com.luna.school.query.permission;

import com.luna.school.entite.PermissionPersonnelTable;
import com.luna.school.mapper.PermissionPersonnelMapper;
import com.luna.school.permission.application.vm.PermissionPersonnelVM;
import com.luna.school.repository.JpaPermissionPersonnelRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListePermissionPersonnel implements
    GestionnaireRequete<List<PermissionPersonnelVM>, Void> {

  private final JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository;
  private final PermissionPersonnelMapper permissionPersonnelMapper;

  public QueryListePermissionPersonnel(
      JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository) {
    this.jpaPermissionPersonnelRepository = jpaPermissionPersonnelRepository;
    permissionPersonnelMapper = PermissionPersonnelMapper.INSTANCE;
  }

  @Override
  public List<PermissionPersonnelVM> requete(Void var1) {
    List<PermissionPersonnelTable> permissionPersonnelTables =
        this.jpaPermissionPersonnelRepository.findAll();
    return permissionPersonnelTables.stream()
        .map(this.permissionPersonnelMapper::permissionPersonnelTableVersPermissionPersonnelVM)
        .collect(Collectors.toList());
  }
}
