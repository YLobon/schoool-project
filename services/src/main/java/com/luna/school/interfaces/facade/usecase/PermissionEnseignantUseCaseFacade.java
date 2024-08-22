package com.luna.school.interfaces.facade.usecase;


import com.luna.school.permission.application.commande.CreerPermissionEnseignantCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEnseignantCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface PermissionEnseignantUseCaseFacade {

  void creer(CreerPermissionEnseignantCommande commande);

  void modifier(ModifierPermissionEnseignantCommande commande);

}
