package com.luna.school.interfaces.facade.usecase;

import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.inscription.application.commande.ModifierInscriptionCommande;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:16 a.m..
 */
public interface InscriptionUseCaseFacade {

  void creer(CreerInscriptionCommande commande);

  void modifier(ModifierInscriptionCommande commande);


  void supprimer(UUID id);
}
