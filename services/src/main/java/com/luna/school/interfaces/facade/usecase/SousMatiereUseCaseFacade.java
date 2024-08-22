package com.luna.school.interfaces.facade.usecase;


import com.luna.school.matiere.application.commande.CreerSousMatiereComande;
import com.luna.school.matiere.application.commande.ModifierSousMatierCommande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface SousMatiereUseCaseFacade {

  void creer(CreerSousMatiereComande commande);

  void modifier(ModifierSousMatierCommande commande);

  void supprimer(UUID id);
}
