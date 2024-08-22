package com.luna.school.matiere.application.gestionnairecommande;

import com.luna.school.matiere.application.casutilisation.ModifierMatiere;
import com.luna.school.matiere.application.commande.ModifiereMatierCommande;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 8:19 a.m..
 */
public class ModifierMatiereGestionnaireCommande implements
    GestionnaireCommande<ModifiereMatierCommande> {

  private final ModifierMatiere modifierMatiere;

  public ModifierMatiereGestionnaireCommande(MatiereRepositoryPort matiereRepositoryPort) {
    modifierMatiere = new ModifierMatiere(matiereRepositoryPort);
  }

  @Override
  public void execute(ModifiereMatierCommande commande) {
    this.modifierMatiere.modifier(commande);
  }
}
