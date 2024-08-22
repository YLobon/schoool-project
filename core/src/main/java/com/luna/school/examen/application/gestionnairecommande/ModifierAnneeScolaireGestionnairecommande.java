package com.luna.school.examen.application.gestionnairecommande;


import com.luna.school.anneescolaire.application.casutilisation.ModifierAnneeScolaire;
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class ModifierAnneeScolaireGestionnairecommande implements
    GestionnaireCommande<ModifierAnneeScolaireCammande> {

  private final ModifierAnneeScolaire modifierAnneeScolaire;

  public ModifierAnneeScolaireGestionnairecommande(
      AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.modifierAnneeScolaire = new ModifierAnneeScolaire(anneeScolaireRepositoryPort);
  }

  @Override
  public void execute(ModifierAnneeScolaireCammande commande) {
    this.modifierAnneeScolaire.modifier(commande);
  }
}
