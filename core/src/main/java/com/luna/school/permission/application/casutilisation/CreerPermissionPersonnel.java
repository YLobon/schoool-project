package com.luna.school.permission.application.casutilisation;

import com.luna.school.etudiant.application.exception.EtudiantException;
import com.luna.school.permission.application.commande.CreerPermissionPersonnelCommande;
import com.luna.school.permission.application.port.PermissionPersonnelRepositoryPort;
import com.luna.school.permission.domaine.entite.PermissionPersonnel;
import com.luna.school.permission.domaine.exception.PermissionException;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerPermissionPersonnel {

  private final PersonnelRepositoryPort personnelRepositoryPort;
  private final PermissionPersonnelRepositoryPort permissionPersonnelRepositoryPort;

  public CreerPermissionPersonnel(PersonnelRepositoryPort personnelRepositoryPort,
      PermissionPersonnelRepositoryPort permissionPersonnelRepositoryPort) {
    this.personnelRepositoryPort = personnelRepositoryPort;
    this.permissionPersonnelRepositoryPort = permissionPersonnelRepositoryPort;
  }


  public void creer(CreerPermissionPersonnelCommande commande) {
    this.verifierOrdreDate(commande.getDateDebut(), commande.getDateFin());
    Personnel personnel = this.enseignantExiste(commande.getPersonnelId());
    var permissionPersonnel = new PermissionPersonnel();
    permissionPersonnel.setId(UUID.randomUUID());
    permissionPersonnel.setDateDebut(commande.getDateDebut());
    permissionPersonnel.setDateFin(commande.getDateFin());
    permissionPersonnel.setDescription(commande.getDescription());
    permissionPersonnel.setPersonnel(personnel);
    this.permissionPersonnelRepositoryPort.enregistrerPermissionPersonnel(permissionPersonnel);
  }

  private Personnel enseignantExiste(UUID enseignantId) {
    Personnel personnel = this.personnelRepositoryPort.recupererParId(enseignantId);
    if (Objects.nonNull(personnel)) {
      return personnel;
    }else {
      throw new EtudiantException("Ce personnel n'existe pas !");
    }
  }

  private void verifierOrdreDate(LocalDate dateDebut, LocalDate dateFin) {
    if (dateFin.isBefore(dateDebut)) {
      throw new PermissionException("La date de fin ne peut pas être avant la date de début !");
    }
  }
}
