package com.luna.school.matiere.application.gestionnairecommande;

import com.luna.school.matiere.application.casutilisation.CreerMatiere;
import com.luna.school.matiere.application.commande.CreerMatiereCommande;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-10
 */
public class GestionnaireCreerMatierCommande implements
    GestionnaireCommande<CreerMatiereCommande> {

  private final CreerMatiere creerMatiere;

  public GestionnaireCreerMatierCommande(MatiereRepositoryPort matiereRepositoryPort) {
    this.creerMatiere = new CreerMatiere(matiereRepositoryPort);
  }

  @Override
  public void execute(CreerMatiereCommande commande) {
    this.creerMatiere.Creer(commande);
  }
}
