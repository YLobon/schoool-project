package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.interfaces.facade.usecase.PermissionEtudiantUseCaseFacade;
import com.luna.school.permission.application.commande.CreerPermissionEleveCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEleveCommande;
import com.luna.school.permission.application.gestionnairecommande.CreerPermissionEtudiantGestionnaireCommande;
import com.luna.school.permission.application.gestionnairecommande.ModifierPermissionEtudiantGestionnaireCommande;
import com.luna.school.permission.application.port.PermissionEtudiantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class PermissionEtudiantUseCaseFacadeImpl implements PermissionEtudiantUseCaseFacade {

  private final GestionnaireCommande<CreerPermissionEleveCommande> gestionnaireCreerPermission;
  private final GestionnaireCommande<ModifierPermissionEleveCommande>
      gestionnaireModifierPermission;


  public PermissionEtudiantUseCaseFacadeImpl(
      PermissionEtudiantRepositoryPort permissionEtudiantRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort) {
    gestionnaireCreerPermission = new CreerPermissionEtudiantGestionnaireCommande(
        etudiantRepositoryPort, permissionEtudiantRepositoryPort);
    gestionnaireModifierPermission = new ModifierPermissionEtudiantGestionnaireCommande(
        etudiantRepositoryPort, permissionEtudiantRepositoryPort);
  }

  @Override
  public void creer(CreerPermissionEleveCommande commande) {
    this.gestionnaireCreerPermission.execute(commande);
  }

  @Override
  public void modifier(ModifierPermissionEleveCommande commande) {
    this.gestionnaireModifierPermission.execute(commande);
  }


}
