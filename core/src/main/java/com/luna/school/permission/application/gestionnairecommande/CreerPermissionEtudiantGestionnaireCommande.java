package com.luna.school.permission.application.gestionnairecommande;


import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.permission.application.casutilisation.CreerPermissionEtudiant;
import com.luna.school.permission.application.commande.CreerPermissionEleveCommande;
import com.luna.school.permission.application.port.PermissionEtudiantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerPermissionEtudiantGestionnaireCommande implements
    GestionnaireCommande<CreerPermissionEleveCommande> {

  private final CreerPermissionEtudiant creerPermissionEtudiant;

  public CreerPermissionEtudiantGestionnaireCommande(EtudiantRepositoryPort etudiantRepositoryPort, PermissionEtudiantRepositoryPort permissionEtudiantRepositoryPort) {
    this.creerPermissionEtudiant = new CreerPermissionEtudiant(etudiantRepositoryPort, permissionEtudiantRepositoryPort);
  }

  @Override
  public void execute(CreerPermissionEleveCommande commande) {
    this.creerPermissionEtudiant.creer(commande);
  }
}
