package com.luna.school.interfaces.facade.usecase;


import com.luna.school.serie.application.commande.CreerSerieCommande;
import com.luna.school.serie.application.commande.ModifierSerieCommande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface SerieUseCaseFacade {

  void creer(CreerSerieCommande commande);

  void modifier(ModifierSerieCommande commande);

  void supprimer(UUID id);
}
