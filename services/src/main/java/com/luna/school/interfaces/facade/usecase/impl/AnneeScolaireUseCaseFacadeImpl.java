package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.anneescolaire.application.casutilisation.SupprimerAnneeScolaire;
import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.anneescolaire.application.gestionnairecommande.CreerAnneeGestionnairecommande;
import com.luna.school.anneescolaire.application.gestionnairecommande.ModifierAnneeScolaireGestionnairecommande;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.interfaces.facade.usecase.AnneeScolaireUseCaseFacade;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class AnneeScolaireUseCaseFacadeImpl implements AnneeScolaireUseCaseFacade {

  private final GestionnaireCommande<CreerAnneeScolaireCommande> gestionnaireCreerAnneeScolaire;
  private final GestionnaireCommande<ModifierAnneeScolaireCammande> gestionnaireModifierAnneeScolaire;
  private final SupprimerAnneeScolaire supprimerAnneeScolaireGestionnaire;

  public AnneeScolaireUseCaseFacadeImpl(AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    gestionnaireCreerAnneeScolaire = new CreerAnneeGestionnairecommande(anneeScolaireRepositoryPort);
    gestionnaireModifierAnneeScolaire = new ModifierAnneeScolaireGestionnairecommande(
        anneeScolaireRepositoryPort);
    this.supprimerAnneeScolaireGestionnaire = new SupprimerAnneeScolaire(
        anneeScolaireRepositoryPort);
  }

  @Override
  public void creer(CreerAnneeScolaireCommande commande) {
    this.gestionnaireCreerAnneeScolaire.execute(commande);
  }

  @Override
  public void modifier(ModifierAnneeScolaireCammande commande) {
    this.gestionnaireModifierAnneeScolaire.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.supprimerAnneeScolaireGestionnaire.supprimer(id);
  }
}
