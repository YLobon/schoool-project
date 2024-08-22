package com.luna.school.interfaces.facade.usecase;


import com.luna.school.permission.application.commande.CreerPermissionEleveCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEleveCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface PermissionEtudiantUseCaseFacade {

  void creer(CreerPermissionEleveCommande commande);

  void modifier(ModifierPermissionEleveCommande commande);
}
