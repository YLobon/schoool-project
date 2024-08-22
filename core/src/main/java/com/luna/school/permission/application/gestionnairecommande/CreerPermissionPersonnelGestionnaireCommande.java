package com.luna.school.permission.application.gestionnairecommande;


import com.luna.school.permission.application.casutilisation.CreerPermissionPersonnel;
import com.luna.school.permission.application.commande.CreerPermissionPersonnelCommande;
import com.luna.school.permission.application.port.PermissionPersonnelRepositoryPort;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerPermissionPersonnelGestionnaireCommande implements
    GestionnaireCommande<CreerPermissionPersonnelCommande> {

  private final CreerPermissionPersonnel creerPermissionPersonnel;

  public CreerPermissionPersonnelGestionnaireCommande(
      PersonnelRepositoryPort personnelRepositoryPort,
      PermissionPersonnelRepositoryPort permissionPersonnelRepositoryPort) {
    this.creerPermissionPersonnel = new CreerPermissionPersonnel(personnelRepositoryPort, permissionPersonnelRepositoryPort);
  }

  @Override
  public void execute(CreerPermissionPersonnelCommande commande) {
    this.creerPermissionPersonnel.creer(commande);
  }
}
