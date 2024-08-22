package com.luna.school.niveau.application.gestionnairecommande;

import com.luna.school.niveau.application.casutilisation.ModifierNiveau;
import com.luna.school.niveau.application.commande.ModifierNiveauCommande;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireModifierNiveauCommande implements GestionnaireCommande<ModifierNiveauCommande> {
private final ModifierNiveau modifierNiveau;

  public GestionnaireModifierNiveauCommande(NiveauRepositoryPort niveauRepositoryPort) {
    this.modifierNiveau = new ModifierNiveau(niveauRepositoryPort);
  }

  @Override
  public void execute(ModifierNiveauCommande commande) {
    this.modifierNiveau.modifier(commande);
  }
}
