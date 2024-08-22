package com.luna.school.interfaces.facade.usecase;


import com.luna.school.permission.application.commande.CreerPermissionPersonnelCommande;
import com.luna.school.permission.application.commande.ModifierPermissionPersonnelCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface PermissionPersonnelUseCaseFacade {

  void creer(CreerPermissionPersonnelCommande commande);

  void modifier(ModifierPermissionPersonnelCommande commande);

}
