package com.luna.school.interfaces.facade.usecase;

import com.luna.school.niveau.application.commande.CreerNiveauCommande;
import com.luna.school.niveau.application.commande.ModifierNiveauCommande;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:16 a.m..
 */
public interface NiveauCaseFacade {

  void creer(CreerNiveauCommande commande);

  void modifier(ModifierNiveauCommande commande);



  void supprimer(UUID id);

}
