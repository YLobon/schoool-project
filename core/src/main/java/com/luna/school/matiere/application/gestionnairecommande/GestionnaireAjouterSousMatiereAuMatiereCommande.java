package com.luna.school.matiere.application.gestionnairecommande;

import com.luna.school.matiere.application.casutilisation.AjouterSousMatiereAuMatiere;
import com.luna.school.matiere.application.commande.AssocierSousMatiereAuMatiereCommande;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-21
 */
public class GestionnaireAjouterSousMatiereAuMatiereCommande implements
    GestionnaireCommande<AssocierSousMatiereAuMatiereCommande> {

  private final AjouterSousMatiereAuMatiere ajouterSousMatiereAuMatiere;

  public GestionnaireAjouterSousMatiereAuMatiereCommande(
      SousMatiereRepositoryPort sousMatiereRepositoryPort,
      MatiereRepositoryPort matiereRepositoryPort
  ) {
    this.ajouterSousMatiereAuMatiere = new AjouterSousMatiereAuMatiere(sousMatiereRepositoryPort,
        matiereRepositoryPort);
  }

  @Override
  public void execute(AssocierSousMatiereAuMatiereCommande commande) {
    this.ajouterSousMatiereAuMatiere.ajouterSousMatiere(commande);
  }
}
