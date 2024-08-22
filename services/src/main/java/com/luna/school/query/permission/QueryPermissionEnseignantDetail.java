package com.luna.school.query.permission;

import com.luna.school.entite.PermissionEnseignantTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.PermissionEnseignantMapper;
import com.luna.school.permission.application.vm.PermissionEnseignantVM;
import com.luna.school.repository.JpaPermissionEnseignantRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryPermissionEnseignantDetail implements
    GestionnaireRequete<PermissionEnseignantVM, UUID> {

  private final JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository;
  private final PermissionEnseignantMapper permissionEnseignantMapper;

  public QueryPermissionEnseignantDetail(
      JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository) {
    this.jpaPermissionEnseignantRepository = jpaPermissionEnseignantRepository;
    permissionEnseignantMapper = PermissionEnseignantMapper.INSTANCE;
  }

  @Override
  public PermissionEnseignantVM requete(UUID id) {
    Optional<PermissionEnseignantTable> optionalPermissionEnseignantTable = this.jpaPermissionEnseignantRepository.findById(
        id);
    if (optionalPermissionEnseignantTable.isPresent()) {
      var permissionEnseignantTable = optionalPermissionEnseignantTable.get();
      return this.permissionEnseignantMapper
          .permissionEnseignantTableVersPermissionEnseignantVM(permissionEnseignantTable);
    }
    throw new NonTrouveException(
        "La permission avec l'identifiant est " + id + " est introuvable !");
  }

}
