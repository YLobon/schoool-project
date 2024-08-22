package com.luna.school.permission.application.casutilisation;

import com.luna.school.etudiant.application.exception.EtudiantException;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.permission.application.commande.ModifierPermissionEleveCommande;
import com.luna.school.permission.application.port.PermissionEtudiantRepositoryPort;
import com.luna.school.permission.domaine.entite.PermissionApprenant;
import com.luna.school.permission.domaine.exception.PermissionException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class ModifierPermissionEtudiant {

  private final EtudiantRepositoryPort etudiantRepositoryPort;
  private final PermissionEtudiantRepositoryPort permissionEtudiantRepositoryPort;

  public ModifierPermissionEtudiant(
      EtudiantRepositoryPort etudiantRepositoryPort,
      PermissionEtudiantRepositoryPort permissionEtudiantRepositoryPort) {
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.permissionEtudiantRepositoryPort = permissionEtudiantRepositoryPort;
  }

  public void modifier(ModifierPermissionEleveCommande commande) {
    this.verifierOrdreDate(commande.getDateDebut(), commande.getDateFin());
    PermissionApprenant permissionEtudiant = this.recupererPermissionEtudiant(
        commande.getPermissionId());
    Etudiant etudiant = this.etudiantExiste(commande.getEleveId());
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
    } else {
      throw new EtudiantException("Cet élève n'existe pas !");
    }
  }

  private PermissionApprenant recupererPermissionEtudiant(UUID permissionEtudiantId) {
    PermissionApprenant permissionApprenant = permissionEtudiantRepositoryPort.recupererParId(
        permissionEtudiantId);
    if (Objects.nonNull(permissionApprenant)) {
      return permissionApprenant;
    } else {
      throw new EtudiantException("Cette permission élève n'existe pas !");
    }
  }

  private void verifierOrdreDate(LocalDate dateDebut, LocalDate dateFin) {
    if (dateFin.isBefore(dateDebut)) {
      throw new PermissionException("La date de fin ne peut pas être avant la date de début !");
    }
  }
}
