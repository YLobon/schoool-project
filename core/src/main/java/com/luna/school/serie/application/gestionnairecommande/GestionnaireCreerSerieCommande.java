package com.luna.school.serie.application.gestionnairecommande;

import com.luna.school.serie.application.casutilisation.CreerSerie;
import com.luna.school.serie.application.commande.CreerSerieCommande;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireCreerSerieCommande implements GestionnaireCommande<CreerSerieCommande> {

  private final CreerSerie creerSerie;

  public GestionnaireCreerSerieCommande(SerieRepositoryPort serieRepositoryPort) {
    this.creerSerie = new CreerSerie(serieRepositoryPort);
  }

  @Override
  public void execute(CreerSerieCommande commande) {
    this.creerSerie.creer(commande);
  }
}
