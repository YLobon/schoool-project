package com.luna.school.serie.application.gestionnairecommande;

import com.luna.school.serie.application.casutilisation.ModifierSerie;
import com.luna.school.serie.application.commande.ModifierSerieCommande;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireModifierSerieCommande implements
    GestionnaireCommande<ModifierSerieCommande> {

  private final ModifierSerie modifierSerie;

  public GestionnaireModifierSerieCommande(SerieRepositoryPort serieRepositoryPort) {
    this.modifierSerie = new ModifierSerie(serieRepositoryPort);
  }

  @Override
  public void execute(ModifierSerieCommande commande) {
    this.modifierSerie.modifier(commande);
  }
}
