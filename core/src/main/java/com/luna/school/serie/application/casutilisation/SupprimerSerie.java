package com.luna.school.serie.application.casutilisation;

import com.luna.school.serie.application.port.SerieRepositoryPort;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class SupprimerSerie {
private final SerieRepositoryPort serieRepositoryPort;

  public SupprimerSerie(SerieRepositoryPort serieRepositoryPort) {
    this.serieRepositoryPort = serieRepositoryPort;
  }

  public void supprimer(UUID serieId) {
    this.serieRepositoryPort.supprimer(serieId);
  }
}
