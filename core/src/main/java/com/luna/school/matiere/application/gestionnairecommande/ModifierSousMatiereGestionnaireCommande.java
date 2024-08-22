package com.luna.school.matiere.application.gestionnairecommande;

import com.luna.school.matiere.application.casutilisation.ModifierSousMatiere;
import com.luna.school.matiere.application.commande.ModifierSousMatierCommande;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 8:19 a.m..
 */
public class ModifierSousMatiereGestionnaireCommande implements
    GestionnaireCommande<ModifierSousMatierCommande> {

  private final ModifierSousMatiere modifierSousMatiere;

  public ModifierSousMatiereGestionnaireCommande(
      SousMatiereRepositoryPort sousMatiereRepositoryPort) {
    modifierSousMatiere = new ModifierSousMatiere(sousMatiereRepositoryPort);
  }

  @Override
  public void execute(ModifierSousMatierCommande commande) {
    this.modifierSousMatiere.modifier(commande);
  }
}
