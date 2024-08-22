package com.luna.school.query.permission;

import com.luna.school.entite.PermissionEtudiantTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.PermissionEtudiantMapper;
import com.luna.school.permission.application.vm.PermissionEtudiantVM;
import com.luna.school.repository.JpaPermissionEtudiantRepository;
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
public class QueryPermissionEtudiantDetail implements GestionnaireRequete<PermissionEtudiantVM, UUID> {

  private final JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository;
  private final PermissionEtudiantMapper permissionEtudiantMapper;

  public QueryPermissionEtudiantDetail(
      JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository) {
    this.jpaPermissionEtudiantRepository = jpaPermissionEtudiantRepository;
    permissionEtudiantMapper = PermissionEtudiantMapper.INSTANCE;
  }


  @Override
  public PermissionEtudiantVM requete(UUID id) {
    Optional<PermissionEtudiantTable> permissionEtudiantTableOptional = this.jpaPermissionEtudiantRepository.findById(id);
    if (permissionEtudiantTableOptional.isPresent()) {
      PermissionEtudiantTable permissionEtudiantTable = permissionEtudiantTableOptional.get();
      return this.permissionEtudiantMapper
          .permissionEtudiantTableVersPermissionEtudiantVM(permissionEtudiantTable);
    }
    throw new NonTrouveException(
        "Le personnel avec l'identifiant est " + id + " est introuvable !");
  }

}
