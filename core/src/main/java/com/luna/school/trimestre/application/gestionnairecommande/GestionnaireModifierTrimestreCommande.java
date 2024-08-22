package com.luna.school.trimestre.application.gestionnairecommande;

import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.casutilisation.ModifierTrimestre;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireModifierTrimestreCommande implements
    GestionnaireCommande<ModifierTrimestreCommande> {

  private final ModifierTrimestre modifierTrimestre;

  public GestionnaireModifierTrimestreCommande(TrimestreRepositoryPort trimestreRepositoryPort,
      AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    modifierTrimestre = new ModifierTrimestre(trimestreRepositoryPort, anneeScolaireRepositoryPort);
  }

  @Override
  public void execute(ModifierTrimestreCommande commande) {
    this.modifierTrimestre.modifier(commande);
  }
}
