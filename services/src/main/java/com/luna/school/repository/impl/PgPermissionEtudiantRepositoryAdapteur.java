package com.luna.school.repository.impl;

import com.luna.school.entite.PermissionEtudiantTable;
import com.luna.school.mapper.PermissionEtudiantMapper;
import com.luna.school.permission.application.port.PermissionEtudiantRepositoryPort;
import com.luna.school.permission.domaine.entite.PermissionApprenant;
import com.luna.school.permission.domaine.exception.PermissionException;
import com.luna.school.repository.JpaPermissionEtudiantRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-22 1:22 p.m..
 */
@Repository
public class PgPermissionEtudiantRepositoryAdapteur implements PermissionEtudiantRepositoryPort {

  private final JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository;
  private final PermissionEtudiantMapper permissionEtudiantMapper;

  public PgPermissionEtudiantRepositoryAdapteur(
      JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository) {
    this.jpaPermissionEtudiantRepository = jpaPermissionEtudiantRepository;
    permissionEtudiantMapper = PermissionEtudiantMapper.INSTANCE;
  }

  @Override
  public void enregistrerPermissionEtudiant(PermissionApprenant permissionApprenant) {
    PermissionEtudiantTable permissionEtudiantTable = this.permissionEtudiantMapper
        .permissionApprenantVersPermissionEtudiantTable(permissionApprenant);
    this.jpaPermissionEtudiantRepository.save(permissionEtudiantTable);
  }

  @Override
  public PermissionApprenant recupererParId(UUID id) {

    Optional<PermissionEtudiantTable> permissionEtudiantTableOptional = this.jpaPermissionEtudiantRepository.findById(
        id);
    if (permissionEtudiantTableOptional.isPresent()) {
      PermissionEtudiantTable permissionEtudiantTable = permissionEtudiantTableOptional.get();
      return this.permissionEtudiantMapper.permissionEtudiantTableVersPermissionApprenant(
          permissionEtudiantTable);
    } else {
      throw new PermissionException("La permission est introuvable !");
    }
  }

  @Override
  public void suprimer(UUID id) {
    try {
      this.jpaPermissionEtudiantRepository.deleteById(id);
    } catch (Exception e) {
      String message = "L'identifiant " + id + " est introuvable !";
      throw new PermissionException(message);
    }
  }
}
