package com.luna.school.permission.application.gestionnairecommande;


import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.permission.application.casutilisation.ModifierPermissionEtudiant;
import com.luna.school.permission.application.commande.ModifierPermissionEleveCommande;
import com.luna.school.permission.application.port.PermissionEtudiantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class ModifierPermissionEtudiantGestionnaireCommande implements
    GestionnaireCommande<ModifierPermissionEleveCommande> {

  private final ModifierPermissionEtudiant modifierPermissionEtudiant;

  public ModifierPermissionEtudiantGestionnaireCommande(EtudiantRepositoryPort etudiantRepositoryPort, PermissionEtudiantRepositoryPort permissionEtudiantRepositoryPort) {
    this.modifierPermissionEtudiant = new ModifierPermissionEtudiant(etudiantRepositoryPort, permissionEtudiantRepositoryPort);
  }

  @Override
  public void execute(ModifierPermissionEleveCommande commande) {
    this.modifierPermissionEtudiant.modifier(commande);
  }
}
