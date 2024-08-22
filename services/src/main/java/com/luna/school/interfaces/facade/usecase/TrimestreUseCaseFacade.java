package com.luna.school.interfaces.facade.usecase;

import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:16 a.m..
 */
public interface TrimestreUseCaseFacade {

  void creer(CreerTrimestreCommande commande);

  void modifier(ModifierTrimestreCommande commande);

  void supprimer(UUID id);

}
