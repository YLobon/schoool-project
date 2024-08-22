package com.luna.school.repository.impl;


import com.luna.school.entite.PermissionPersonnelTable;
import com.luna.school.mapper.PermissionPersonnelMapper;
import com.luna.school.permission.application.port.PermissionPersonnelRepositoryPort;
import com.luna.school.permission.domaine.entite.PermissionPersonnel;
import com.luna.school.permission.domaine.exception.PermissionException;
import com.luna.school.repository.JpaPermissionPersonnelRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * @author BOUA YVES 2024-03-21
 */
@Repository
public class PgPermissionPersonnelRepositoryAdapteur implements
    PermissionPersonnelRepositoryPort {

  private final JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository;
  private final PermissionPersonnelMapper permissionPersonnelMapper;

  public PgPermissionPersonnelRepositoryAdapteur(
      JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository) {
    this.jpaPermissionPersonnelRepository = jpaPermissionPersonnelRepository;
    permissionPersonnelMapper = PermissionPersonnelMapper.INSTANCE;
  }


  @Override
  public void enregistrerPermissionPersonnel(PermissionPersonnel permissionPersonnel) {
    PermissionPersonnelTable permissionPersonnelTable = this.permissionPersonnelMapper
        .permissionPersonnelVersPermissionPersonnelTable(permissionPersonnel);
    this.jpaPermissionPersonnelRepository.save(permissionPersonnelTable);
  }

  @Override
  public PermissionPersonnel recupererParId(UUID id) {

    Optional<PermissionPersonnelTable> permissionPersonnelTableOptional =
        this.jpaPermissionPersonnelRepository.findById(id);
    if (permissionPersonnelTableOptional.isPresent()) {
      PermissionPersonnelTable permissionPersonnelTable = permissionPersonnelTableOptional.get();
      return this.permissionPersonnelMapper.permissionPersonnelTableVersPermissionPersonnel(
          permissionPersonnelTable);
    } else {
      throw new PermissionException("Permission non trouvée");
    }
  }

  @Override
  public void suprimer(UUID id) {
    try {
      this.jpaPermissionPersonnelRepository.deleteById(id);
    } catch (Exception e) {
      String message = "L'identifiant " + id + " est introuvable !";
      throw new PermissionException(message);
    }
  }


}
