package com.luna.school.classe.application.gestionnairecommande;

import com.luna.school.classe.application.casutilisation.AjouterMatierClasse;
import com.luna.school.classe.application.commande.AjouterMatierClasseCommande;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-22
 */
public class GestionnaireAjouterMatierClasseCommande implements
    GestionnaireCommande<AjouterMatierClasseCommande> {

  private final AjouterMatierClasse ajouterMatierClasse;

  public GestionnaireAjouterMatierClasseCommande(MatiereRepositoryPort matiereRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort) {
    ajouterMatierClasse = new AjouterMatierClasse(matiereRepositoryPort, classeRepositoryPort);
  }

  @Override
  public void execute(AjouterMatierClasseCommande commande) {
    this.ajouterMatierClasse.ajouterMatierClasse(commande);
  }
}
