package com.luna.school.factory;

import com.luna.school.entite.PermissionPersonnelTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.repository.JpaPermissionPersonnelRepository;
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
public class PermissionPersonnelFactory {
private final JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository;
private final PersonnelFactory personnelFactory;

  public PermissionPersonnelFactory(
      JpaPermissionPersonnelRepository jpaPermissionPersonnelRepository,
      PersonnelFactory personnelFactory) {
    this.jpaPermissionPersonnelRepository = jpaPermissionPersonnelRepository;
    this.personnelFactory = personnelFactory;
  }


  public PermissionPersonnelTable permissionPersonnel(){
    PersonnelTable personnel = this.personnelFactory.personnel();
    var permissionPersonnel = new PermissionPersonnelTable();
    permissionPersonnel.setId(UUID.randomUUID());
    permissionPersonnel.setDateDebut(LocalDate.now());
    permissionPersonnel.setDateFin(LocalDate.of(2024,2,11));
    permissionPersonnel.setDescription("Déplacement pour des raisons concernant l'école");
    permissionPersonnel.setPersonnel(personnel);
    return this.jpaPermissionPersonnelRepository.save(permissionPersonnel);
  }
}
