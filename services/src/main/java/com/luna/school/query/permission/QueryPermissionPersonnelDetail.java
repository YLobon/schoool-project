package com.luna.school.query.permission;

import com.luna.school.entite.PermissionPersonnelTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.PermissionPersonnelMapper;
import com.luna.school.permission.application.vm.PermissionPersonnelVM;
import com.luna.school.repository.JpaPermissionPersonnelRepository;
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
public class QueryPermissionPersonnelDetail implements GestionnaireRequete<PermissionPersonnelVM, UUID> {

  private final JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository;
  private final PermissionPersonnelMapper permissionPersonnelMapper;

  public QueryPermissionPersonnelDetail(
      JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository) {
    this.jpaPermissionPersonnelRepository = jpaPermissionPersonnelRepository;
    permissionPersonnelMapper = PermissionPersonnelMapper.INSTANCE;
  }

  @Override
  public PermissionPersonnelVM requete(UUID id) {
    Optional<PermissionPersonnelTable> permissionPersonnelTableOptional =
        this.jpaPermissionPersonnelRepository.findById(id);
    if (permissionPersonnelTableOptional.isPresent()) {
      PermissionPersonnelTable permissionPersonnelTable = permissionPersonnelTableOptional.get();
      return this.permissionPersonnelMapper
          .permissionPersonnelTableVersPermissionPersonnelVM(permissionPersonnelTable);
    }
    throw new NonTrouveException(
        "La permission avec l'identifiant est " + id + " est introuvable !");
  }
}
