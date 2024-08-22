package com.luna.school.permission.application.gestionnairecommande;


import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.permission.application.casutilisation.CreerPermissionEnseignant;
import com.luna.school.permission.application.commande.CreerPermissionEnseignantCommande;
import com.luna.school.permission.application.port.PermissionEnseignantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerPermissionEnseignantGestionnaireCommande implements
    GestionnaireCommande<CreerPermissionEnseignantCommande> {

  private final CreerPermissionEnseignant creerPermissionEnseignant;

  public CreerPermissionEnseignantGestionnaireCommande(
      EnseignantRepositoryPort enseignantRepositoryPort,
      PermissionEnseignantRepositoryPort permissionEnseignantRepositoryPort) {
    this.creerPermissionEnseignant = new CreerPermissionEnseignant(enseignantRepositoryPort,
        permissionEnseignantRepositoryPort);
  }

  @Override
  public void execute(CreerPermissionEnseignantCommande commande) {
    this.creerPermissionEnseignant.creer(commande);
  }
}
