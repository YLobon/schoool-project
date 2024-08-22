package com.luna.school.etudiant.application.casutilisation;

import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import java.util.UUID;

/**
 * @author BOUA YVES
 */
public class SupprimerPersonnel {
  private final PersonnelRepositoryPort personnelRepositoryPort;

  public SupprimerPersonnel(PersonnelRepositoryPort personnelRepositoryPort) {
    this.personnelRepositoryPort = personnelRepositoryPort;
  }

  public void supprimer(UUID personnelId) {
    this.personnelRepositoryPort.supprimer(personnelId);
  }

}
