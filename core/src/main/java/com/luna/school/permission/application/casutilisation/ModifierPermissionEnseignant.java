package com.luna.school.permission.application.casutilisation;

import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.permission.application.commande.ModifierPermissionEnseignantCommande;
import com.luna.school.permission.application.port.PermissionEnseignantRepositoryPort;
import com.luna.school.permission.domaine.entite.PermissionEnseignant;
import com.luna.school.permission.domaine.exception.PermissionException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class ModifierPermissionEnseignant {
  private final EnseignantRepositoryPort enseignantRepositoryPort;
  private final PermissionEnseignantRepositoryPort permissionEnseignantRepositoryPort;

  public ModifierPermissionEnseignant(EnseignantRepositoryPort enseignantRepositoryPort,
      PermissionEnseignantRepositoryPort permissionEnseignantRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
    this.permissionEnseignantRepositoryPort = permissionEnseignantRepositoryPort;
  }


  public void modifier(ModifierPermissionEnseignantCommande commande) {
    this.verifierOrdreDate(commande.getDateDebut(),commande.getDateFin());
    var permissionEnseignant = this.permissionEnseignantExiste(commande.getPermissionId());
    Enseignant enseignant = this.enseignantExiste(commande.getEnseignantId());
    permissionEnseignant.setId(UUID.randomUUID());
    permissionEnseignant.setDateDebut(commande.getDateDebut());
    permissionEnseignant.setDateFin(commande.getDateFin());
    permissionEnseignant.setDescription(commande.getDescription());
    permissionEnseignant.setEnseignant(enseignant);
    this.permissionEnseignantRepositoryPort.enregistrerPermissionEnseignent(permissionEnseignant);
  }

  private PermissionEnseignant permissionEnseignantExiste(UUID permissionEnseignantId) {
    PermissionEnseignant permissionEnseignant =
        this.permissionEnseignantRepositoryPort.recupererParId(permissionEnseignantId);
    if (Objects.nonNull(permissionEnseignant) || permissionEnseignant.getId() == null) {
      return permissionEnseignant;
    }else {
      throw new EnseignantException("ce enseignant n'existe pas !");
    }
  }

  private Enseignant enseignantExiste(UUID enseignantId) {
    Enseignant enseignant = this.enseignantRepositoryPort.recupererParId(enseignantId);
    if (Objects.nonNull(enseignant) || enseignant.getId() == null) {
      return enseignant;
    }else {
      throw new EnseignantException("ce enseignant n'existe pas !");
    }
  }
  private void verifierOrdreDate(LocalDate dateDebut, LocalDate dateFin) {
    if (dateFin.isBefore(dateDebut)) {
      throw new PermissionException("La date de fin ne peut pas être avant la date de début !");
    }
  }

}
