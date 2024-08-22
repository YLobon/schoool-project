package com.luna.school.repository.impl;


import com.luna.school.entite.PermissionEnseignantTable;
import com.luna.school.mapper.PermissionEnseignantMapper;
import com.luna.school.permission.application.port.PermissionEnseignantRepositoryPort;
import com.luna.school.permission.domaine.entite.PermissionEnseignant;
import com.luna.school.permission.domaine.exception.PermissionException;
import com.luna.school.repository.JpaPermissionEnseignantRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * @author BOUA YVES 2024-03-21
 */
@Repository
public class PgPermissionEnseignantRepositoryAdapteur implements
    PermissionEnseignantRepositoryPort {

  private final JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository;
  private final PermissionEnseignantMapper permissionEnseignantMapper;

  public PgPermissionEnseignantRepositoryAdapteur(
      JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository) {
    this.jpaPermissionEnseignantRepository = jpaPermissionEnseignantRepository;
    permissionEnseignantMapper = PermissionEnseignantMapper.INSTANCE;
  }


  @Override
  public void enregistrerPermissionEnseignent(PermissionEnseignant permissionEnseignant) {
    PermissionEnseignantTable permissionEnseignantTable = this.permissionEnseignantMapper
        .permissionEnseignantVersPermissionEnseignantTable(permissionEnseignant);
    this.jpaPermissionEnseignantRepository.save(permissionEnseignantTable);
  }

  @Override
  public PermissionEnseignant recupererParId(UUID id) {
    Optional<PermissionEnseignantTable> enseignantTableOptional =
        this.jpaPermissionEnseignantRepository.findById(id);
    if (enseignantTableOptional.isPresent()) {
      PermissionEnseignantTable permissionEnseignantTable = enseignantTableOptional.get();
      return this.permissionEnseignantMapper.permissionEnseignantTableVersPermissionEnseignant(
          permissionEnseignantTable);
    } else {
      throw new PermissionException("Permission non trouvée");
    }
  }

  @Override
  public void suprimer(UUID id) {
    try {
      this.jpaPermissionEnseignantRepository.deleteById(id);
    } catch (Exception e) {
      String message = "L'identifiant " + id + " est introuvable !";
      throw new PermissionException(message);
    }
  }


}
