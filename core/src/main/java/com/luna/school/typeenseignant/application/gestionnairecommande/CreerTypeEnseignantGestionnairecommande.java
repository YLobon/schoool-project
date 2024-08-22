package com.luna.school.typeenseignant.application.gestionnairecommande;


import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.typeenseignant.application.casutilisation.CreerTypeEnseignant;
import com.luna.school.typeenseignant.application.commande.CreerTypeEnseignantCommande;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerTypeEnseignantGestionnairecommande implements
    GestionnaireCommande<CreerTypeEnseignantCommande> {

  private final CreerTypeEnseignant creerTypeEnseignant;

  public CreerTypeEnseignantGestionnairecommande(
      TypeEnseignantRepositoryPort typeEnseignantRepositoryPort) {
    this.creerTypeEnseignant = new CreerTypeEnseignant(typeEnseignantRepositoryPort);
  }

  @Override
  public void execute(CreerTypeEnseignantCommande commande) {
    this.creerTypeEnseignant.creer(commande);
  }
}
