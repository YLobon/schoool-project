package com.luna.school.serie.application.casutilisation;

import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.application.vm.SerieDetailsVM;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class RecupererSerieParId {

  private final SerieRepositoryPort serieRepositoryPort;

  public RecupererSerieParId(SerieRepositoryPort serieRepositoryPort) {
    this.serieRepositoryPort = serieRepositoryPort;
  }

  public SerieDetailsVM recupererSerieParId(UUID id) {
    Serie serie = this.serieRepositoryPort.recupererParId(id);
    return new SerieDetailsVM(serie.getId(), serie.getLibelle());
  }
}
