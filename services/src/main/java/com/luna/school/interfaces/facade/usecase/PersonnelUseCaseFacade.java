package com.luna.school.interfaces.facade.usecase;

import com.luna.school.personnel.application.commande.CreerPersonnelCommande;
import com.luna.school.personnel.application.commande.ModifierPersonnelCommande;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:16 a.m..
 */
public interface PersonnelUseCaseFacade {

  void creer(CreerPersonnelCommande commande);

  void modifier(ModifierPersonnelCommande commande);

  void supprimer(UUID id);

}
