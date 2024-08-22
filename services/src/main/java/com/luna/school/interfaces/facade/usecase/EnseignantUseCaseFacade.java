package com.luna.school.interfaces.facade.usecase;


import com.luna.school.enseignant.application.commande.CreerEnseignantCommande;
import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface EnseignantUseCaseFacade {

  void creer(CreerEnseignantCommande commande);

  void modifier(ModifierEnseignantCommande commande);

  void supprimer(UUID id);
}
