package com.luna.school.interfaces.facade.usecase;


import com.luna.school.matiere.application.commande.AssocierSousMatiereAuMatiereCommande;
import com.luna.school.matiere.application.commande.CreerMatiereCommande;
import com.luna.school.matiere.application.commande.ModifiereMatierCommande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface MatiereUseCaseFacade {

  void creer(CreerMatiereCommande commande);

  void modifier(ModifiereMatierCommande commande);

  void supprimer(UUID id);

  void ajouterSousMatiereAuxMatiere(AssocierSousMatiereAuMatiereCommande commande);
}
