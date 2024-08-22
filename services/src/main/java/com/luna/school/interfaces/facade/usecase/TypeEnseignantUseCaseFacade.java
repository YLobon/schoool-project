package com.luna.school.interfaces.facade.usecase;


import com.luna.school.typeenseignant.application.commande.CreerTypeEnseignantCommande;
import com.luna.school.typeenseignant.application.commande.ModifierTypeEnseignantCammande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface TypeEnseignantUseCaseFacade {

  void creer(CreerTypeEnseignantCommande commande);

  void modifier(ModifierTypeEnseignantCammande commande);

  void supprimer(UUID id);
}
