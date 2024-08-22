package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.interfaces.facade.usecase.PermissionEnseignantUseCaseFacade;
import com.luna.school.permission.application.commande.CreerPermissionEnseignantCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEnseignantCommande;
import com.luna.school.permission.application.gestionnairecommande.CreerPermissionEnseignantGestionnaireCommande;
import com.luna.school.permission.application.gestionnairecommande.ModifierPermissionEnseignantGestionnaireCommande;
import com.luna.school.permission.application.port.PermissionEnseignantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class PermissionEnseignantUseCaseFacadeImpl implements PermissionEnseignantUseCaseFacade {

  private final GestionnaireCommande<CreerPermissionEnseignantCommande> gestionnaireCreerPermission;
  private final GestionnaireCommande<ModifierPermissionEnseignantCommande> gestionnaireModifier;


  public PermissionEnseignantUseCaseFacadeImpl(
      PermissionEnseignantRepositoryPort permissionEnseignantRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort) {
    gestionnaireCreerPermission = new CreerPermissionEnseignantGestionnaireCommande(
        enseignantRepositoryPort, permissionEnseignantRepositoryPort);
    gestionnaireModifier = new ModifierPermissionEnseignantGestionnaireCommande(
        enseignantRepositoryPort, permissionEnseignantRepositoryPort);
  }

  @Override
  public void creer(CreerPermissionEnseignantCommande commande) {
    this.gestionnaireCreerPermission.execute(commande);
  }

  @Override
  public void modifier(ModifierPermissionEnseignantCommande commande) {
    this.gestionnaireModifier.execute(commande);
  }


}
