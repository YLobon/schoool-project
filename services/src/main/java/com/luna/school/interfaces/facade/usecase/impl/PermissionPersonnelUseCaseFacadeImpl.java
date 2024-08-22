package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.interfaces.facade.usecase.PermissionPersonnelUseCaseFacade;
import com.luna.school.permission.application.commande.CreerPermissionPersonnelCommande;
import com.luna.school.permission.application.commande.ModifierPermissionPersonnelCommande;
import com.luna.school.permission.application.gestionnairecommande.CreerPermissionPersonnelGestionnaireCommande;
import com.luna.school.permission.application.gestionnairecommande.ModifierPermissionPersonnelGestionnaireCommande;
import com.luna.school.permission.application.port.PermissionPersonnelRepositoryPort;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class PermissionPersonnelUseCaseFacadeImpl implements PermissionPersonnelUseCaseFacade {

  private final GestionnaireCommande<CreerPermissionPersonnelCommande> gestionnaireCreerPermission;
  private final GestionnaireCommande<ModifierPermissionPersonnelCommande> gestionnaireModifierPermission;


  public PermissionPersonnelUseCaseFacadeImpl(
      PermissionPersonnelRepositoryPort permissionPersonnelRepositoryPort,
      PersonnelRepositoryPort personnelRepositoryPort) {
    gestionnaireCreerPermission = new CreerPermissionPersonnelGestionnaireCommande(personnelRepositoryPort, permissionPersonnelRepositoryPort);
    gestionnaireModifierPermission = new ModifierPermissionPersonnelGestionnaireCommande(personnelRepositoryPort, permissionPersonnelRepositoryPort);
  }

  @Override
  public void creer(CreerPermissionPersonnelCommande commande) {
    this.gestionnaireCreerPermission.execute(commande);
  }

  @Override
  public void modifier(ModifierPermissionPersonnelCommande commande) {
    this.gestionnaireModifierPermission.execute(commande);
  }


}
