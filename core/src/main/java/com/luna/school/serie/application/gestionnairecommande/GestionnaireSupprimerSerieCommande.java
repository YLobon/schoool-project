package com.luna.school.serie.application.gestionnairecommande;

import com.luna.school.serie.application.casutilisation.SupprimerSerie;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireSupprimerSerieCommande implements GestionnaireCommande<UUID> {

  private final SupprimerSerie supprimerSerie;

  public GestionnaireSupprimerSerieCommande(SerieRepositoryPort serieRepositoryPort) {
    this.supprimerSerie = new SupprimerSerie(serieRepositoryPort);
  }

  @Override
  public void execute(UUID id) {
    this.supprimerSerie.supprimer(id);
  }
}
