package com.luna.school.anneescolaire.application.gestionnairecommande;


import com.luna.school.anneescolaire.application.casutilisation.CreerAnneeScolaire;
import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerAnneeGestionnairecommande implements
    GestionnaireCommande<CreerAnneeScolaireCommande> {

  private final CreerAnneeScolaire creerAnneeScolaire;

  public CreerAnneeGestionnairecommande(AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.creerAnneeScolaire = new CreerAnneeScolaire(anneeScolaireRepositoryPort);
  }

  @Override
  public void execute(CreerAnneeScolaireCommande commande) {
    this.creerAnneeScolaire.creer(commande);
  }
}
