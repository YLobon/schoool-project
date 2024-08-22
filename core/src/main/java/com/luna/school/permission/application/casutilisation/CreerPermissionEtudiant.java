package com.luna.school.permission.application.casutilisation;

import com.luna.school.etudiant.application.exception.EtudiantException;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.permission.application.commande.CreerPermissionEleveCommande;
import com.luna.school.permission.application.port.PermissionEtudiantRepositoryPort;
import com.luna.school.permission.domaine.entite.PermissionApprenant;
import com.luna.school.permission.domaine.exception.PermissionException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerPermissionEtudiant {
  private final EtudiantRepositoryPort etudiantRepositoryPort;
  private final PermissionEtudiantRepositoryPort permissionEtudiantRepositoryPort;

  public CreerPermissionEtudiant(
      EtudiantRepositoryPort etudiantRepositoryPort, PermissionEtudiantRepositoryPort permissionEtudiantRepositoryPort) {
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.permissionEtudiantRepositoryPort = permissionEtudiantRepositoryPort;
  }

  public void creer(CreerPermissionEleveCommande commande) {

    this.verifierOrdreDate(commande.getDateDebut(), commande.getDateFin());
    Etudiant etudiant = this.etudiantExiste(commande.getEleveId());
    var permissionEtudiant = new PermissionApprenant();
    permissionEtudiant.setId(UUID.randomUUID());
    permissionEtudiant.setDateDebut(commande.getDateDebut());
    permissionEtudiant.setDateFin(commande.getDateFin());
    permissionEtudiant.setDescription(commande.getDescription());
    permissionEtudiant.setEtudiant(etudiant);
    this.permissionEtudiantRepositoryPort.enregistrerPermissionEtudiant(permissionEtudiant);
  }

  private Etudiant etudiantExiste(UUID etudiantId) {
    Etudiant etudiant = this.etudiantRepositoryPort.recupererParId(etudiantId);
    if (Objects.nonNull(etudiant)) {
      return etudiant;
    }else {
      throw new EtudiantException("Cet élève n'existe pas !");
    }
  }

  private void verifierOrdreDate(LocalDate dateDebut, LocalDate dateFin) {
    if (dateFin.isBefore(dateDebut)) {
      throw new PermissionException("La date de fin ne peut pas être avant la date de début !");
    }
  }
}
