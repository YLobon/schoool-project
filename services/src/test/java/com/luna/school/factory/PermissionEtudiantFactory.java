package com.luna.school.factory;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.PermissionEtudiantTable;
import com.luna.school.repository.JpaPermissionEtudiantRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @project school
 * @author BOUA YVES 2024-06-22 5:51 p.m..
 */
@Component
public class PermissionEtudiantFactory {
  private final JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository;
  private final EtudiantFactory etudiantFactory;

  public PermissionEtudiantFactory(JpaPermissionEtudiantRepository jpaPermissionEtudiantRepository,
      EtudiantFactory etudiantFactory) {
    this.jpaPermissionEtudiantRepository = jpaPermissionEtudiantRepository;
    this.etudiantFactory = etudiantFactory;
  }


  public PermissionEtudiantTable permissionEtudiant(){
    EtudiantTable etudiantTable = this.etudiantFactory.genererEtudiant5();
    var permissionEnseignant = new PermissionEtudiantTable();
    permissionEnseignant.setId(UUID.randomUUID());
    permissionEnseignant.setDateDebut(LocalDate.now());
    permissionEnseignant.setDateFin(LocalDate.of(2024,2,11));
    permissionEnseignant.setDescription("congé à cause de son  état de santé");
    permissionEnseignant.setEtudiant(etudiantTable);
    return this.jpaPermissionEtudiantRepository.save(permissionEnseignant);
  }
}
