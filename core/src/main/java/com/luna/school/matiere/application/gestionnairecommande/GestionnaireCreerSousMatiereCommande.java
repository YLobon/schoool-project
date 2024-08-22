package com.luna.school.matiere.application.gestionnairecommande;

import com.luna.school.matiere.application.casutilisation.CreerSousMatiere;
import com.luna.school.matiere.application.commande.CreerSousMatiereComande;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-21
 */
public class GestionnaireCreerSousMatiereCommande implements
    GestionnaireCommande<CreerSousMatiereComande> {

  private final CreerSousMatiere creerSousMatiere;

  public GestionnaireCreerSousMatiereCommande(SousMatiereRepositoryPort sousMatiereRepositoryPort) {
    this.creerSousMatiere = new CreerSousMatiere(sousMatiereRepositoryPort);
  }

  @Override
  public void execute(CreerSousMatiereComande commande) {
    this.creerSousMatiere.Creer(commande);
  }
}
