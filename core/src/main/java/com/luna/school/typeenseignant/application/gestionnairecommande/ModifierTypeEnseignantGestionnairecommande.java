package com.luna.school.typeenseignant.application.gestionnairecommande;


import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.typeenseignant.application.casutilisation.ModifierTypeEnseignant;
import com.luna.school.typeenseignant.application.commande.ModifierTypeEnseignantCammande;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;

/**
 * @author BOUA YVES 2024-03-18
 */
public class ModifierTypeEnseignantGestionnairecommande implements
    GestionnaireCommande<ModifierTypeEnseignantCammande> {

  private final ModifierTypeEnseignant modifierTypeEnseignant;

  public ModifierTypeEnseignantGestionnairecommande(
      TypeEnseignantRepositoryPort typeEnseignantRepositoryPort) {
    modifierTypeEnseignant = new ModifierTypeEnseignant(typeEnseignantRepositoryPort);
  }

  @Override
  public void execute(ModifierTypeEnseignantCammande commande) {
    this.modifierTypeEnseignant.modifier(commande);
  }
}
