package com.luna.school.interfaces.facade.usecase;

import com.luna.school.classe.application.commande.CreerClasseCommande;
import com.luna.school.classe.application.commande.ModifierClasseCommande;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:16 a.m..
 */
public interface ClasseUseCaseFacade {

  void creer(CreerClasseCommande commande);

  void modifier(ModifierClasseCommande commande);

  void supprimer(UUID id);

}
