package com.luna.school.query.permission;

import com.luna.school.entite.PermissionEnseignantTable;
import com.luna.school.mapper.PermissionEnseignantMapper;
import com.luna.school.permission.application.vm.PermissionEnseignantVM;
import com.luna.school.repository.JpaPermissionEnseignantRepository;
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
public class QueryListePermissionEnseignant implements
    GestionnaireRequete<List<PermissionEnseignantVM>, Void> {

  private final JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository;
  private final PermissionEnseignantMapper permissionEnseignantMapper;

  public QueryListePermissionEnseignant(
      JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository) {
    this.jpaPermissionEnseignantRepository = jpaPermissionEnseignantRepository;
    permissionEnseignantMapper = PermissionEnseignantMapper.INSTANCE;
  }

  @Override
  public List<PermissionEnseignantVM> requete(Void var1) {

    List<PermissionEnseignantTable> permissionEnseignantTables =
        this.jpaPermissionEnseignantRepository.findAll();
    return permissionEnseignantTables.stream()
        .map(this.permissionEnseignantMapper::permissionEnseignantTableVersPermissionEnseignantVM)
        .collect(Collectors.toList());
  }
}
