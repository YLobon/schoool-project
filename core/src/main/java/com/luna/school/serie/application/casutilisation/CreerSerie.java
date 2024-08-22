package com.luna.school.serie.application.casutilisation;

import com.luna.school.serie.application.commande.CreerSerieCommande;
import com.luna.school.serie.application.exception.SerieException;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerSerie {

  private final SerieRepositoryPort serieRepositoryPort;
  private final Logger logger = Logger.getLogger(CreerSerie.class.getName());

  public CreerSerie(SerieRepositoryPort serieRepositoryPort) {
    this.serieRepositoryPort = serieRepositoryPort;
  }


  public void creer(CreerSerieCommande commande) {
    this.existeParLibelle(commande.getLibelle());
    var serie = new Serie();
    serie.setId(UUID.randomUUID());
    serie.setLibelle(commande.getLibelle());
    this.serieRepositoryPort.enregistrer(serie);
    logger.info("enregistrement effectué avec succès !");
  }


  private void existeParLibelle(String libelle) {
    boolean existeParLibelle = this.serieRepositoryPort.existeParLibelle(libelle);
    if (existeParLibelle) {
      throw new SerieException("ce libelle existe déjà !");
    }
  }
}