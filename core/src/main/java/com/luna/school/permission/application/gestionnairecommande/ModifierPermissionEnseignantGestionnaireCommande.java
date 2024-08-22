package com.luna.school.permission.application.gestionnairecommande;


import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.permission.application.casutilisation.ModifierPermissionEnseignant;
import com.luna.school.permission.application.commande.ModifierPermissionEnseignantCommande;
import com.luna.school.permission.application.port.PermissionEnseignantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class ModifierPermissionEnseignantGestionnaireCommande implements
    GestionnaireCommande<ModifierPermissionEnseignantCommande> {

  private final ModifierPermissionEnseignant modifierPermissionEnseignant;

  public ModifierPermissionEnseignantGestionnaireCommande(
      EnseignantRepositoryPort enseignantRepositoryPort,
      PermissionEnseignantRepositoryPort permissionEnseignantRepositoryPort) {
    this.modifierPermissionEnseignant = new ModifierPermissionEnseignant(enseignantRepositoryPort,
        permissionEnseignantRepositoryPort);
  }

  @Override
  public void execute(ModifierPermissionEnseignantCommande commande) {
    this.modifierPermissionEnseignant.modifier(commande);
  }
}
