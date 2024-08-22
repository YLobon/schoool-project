package com.luna.school.permission.application.gestionnairecommande;


import com.luna.school.permission.application.casutilisation.ModifierPermissionPersonnel;
import com.luna.school.permission.application.commande.ModifierPermissionPersonnelCommande;
import com.luna.school.permission.application.port.PermissionPersonnelRepositoryPort;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class ModifierPermissionPersonnelGestionnaireCommande implements
    GestionnaireCommande<ModifierPermissionPersonnelCommande> {

  private final ModifierPermissionPersonnel modifierPermissionPersonnel;

  public ModifierPermissionPersonnelGestionnaireCommande(
      PersonnelRepositoryPort personnelRepositoryPort,
      PermissionPersonnelRepositoryPort permissionPersonnelRepositoryPort) {
    this.modifierPermissionPersonnel = new ModifierPermissionPersonnel(personnelRepositoryPort,
        permissionPersonnelRepositoryPort);
  }

  @Override
  public void execute(ModifierPermissionPersonnelCommande commande) {
    this.modifierPermissionPersonnel.modifier(commande);
  }
}
