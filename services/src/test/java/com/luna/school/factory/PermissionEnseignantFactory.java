package com.luna.school.factory;

import com.luna.school.entite.EnseignantTable;
import com.luna.school.entite.PermissionEnseignantTable;
import com.luna.school.repository.JpaPermissionEnseignantRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-22 5:51 p.m..
 */
@Component
public class PermissionEnseignantFactory {
private final JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository;
private final EnseignantFactory enseignantFactory;

  public PermissionEnseignantFactory(
      JpaPermissionEnseignantRepository jpaPermissionEnseignantRepository,
      EnseignantFactory enseignantFactory) {
    this.jpaPermissionEnseignantRepository = jpaPermissionEnseignantRepository;
    this.enseignantFactory = enseignantFactory;
  }


  public PermissionEnseignantTable permissionEnseignant(){
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    var permissionEnseignant = new PermissionEnseignantTable();
    permissionEnseignant.setId(UUID.randomUUID());
    permissionEnseignant.setDateDebut(LocalDate.now());
    permissionEnseignant.setDateFin(LocalDate.of(2024,11,12));
    permissionEnseignant.setDescription("congé pour le repos !");
    permissionEnseignant.setEnseignant(enseignant);
    return this.jpaPermissionEnseignantRepository.save(permissionEnseignant);
  }
}
