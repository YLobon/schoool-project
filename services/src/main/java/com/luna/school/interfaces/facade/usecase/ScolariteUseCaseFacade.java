package com.luna.school.interfaces.facade.usecase;

import com.luna.school.comptabilite.application.commande.PayerScolariteCommande;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:16 a.m..
 */
public interface ScolariteUseCaseFacade {

  void payer(PayerScolariteCommande commande);

  void supprimer(UUID id);
}
