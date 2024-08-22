package com.luna.school.interfaces.facade.usecase;


import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface AnneeScolaireUseCaseFacade {

  void creer(CreerAnneeScolaireCommande commande);

  void modifier(ModifierAnneeScolaireCammande commande);

  void supprimer(UUID id);
}
