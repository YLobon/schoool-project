package com.luna.school.query.permission;

import com.luna.school.entite.PermissionEtudiantTable;
import com.luna.school.mapper.PermissionEtudiantMapper;
import com.luna.school.permission.application.vm.PermissionEtudiantVM;
import com.luna.school.repository.JpaPermissionEtudiantRepository;
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
public class QueryListePermissionEtudiant implements
    GestionnaireRequete<List<PermissionEtudiantVM>, Void> {

  private final JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository;
  private final PermissionEtudiantMapper permissionEtudiantMapper;

  public QueryListePermissionEtudiant(
      JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository) {
    this.jpaPermissionEtudiantRepository = jpaPermissionEtudiantRepository;
    permissionEtudiantMapper = PermissionEtudiantMapper.INSTANCE;
  }

  @Override
  public List<PermissionEtudiantVM> requete(Void var1) {
    List<PermissionEtudiantTable> permissionEtudiantTables = this.jpaPermissionEtudiantRepository.findAll();
    return permissionEtudiantTables.stream()
        .map(this.permissionEtudiantMapper::permissionEtudiantTableVersPermissionEtudiantVM)
        .collect(Collectors.toList());
  }
}
