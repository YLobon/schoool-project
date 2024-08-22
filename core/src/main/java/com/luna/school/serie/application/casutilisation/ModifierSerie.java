package com.luna.school.serie.application.casutilisation;

import com.luna.school.serie.application.commande.ModifierSerieCommande;
import com.luna.school.serie.application.exception.SerieException;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ModifierSerie {

  private final Logger logger = Logger.getLogger(CreerSerie.class.getName());
  private final SerieRepositoryPort serieRepositoryPort;

  public ModifierSerie(SerieRepositoryPort serieRepositoryPort) {
    this.serieRepositoryPort = serieRepositoryPort;
  }


  public void modifier(ModifierSerieCommande commande) {
    Serie serie = this.serieRepositoryPort.recupererParId(commande.getId());
      String libelle = commande.getLibelle();
      this.verifierLibelle(serie,libelle);
      serie.setLibelle(libelle);
      this.serieRepositoryPort.enregistrer(serie);
      logger.info("La serie modifier avec succès !");

  }

  private void verifierLibelle(Serie serie,String libelle) {
    boolean existeParLibelle = this.serieRepositoryPort.existeParLibelle(libelle);
    if (existeParLibelle && !Objects.equals(serie.getLibelle(), libelle)) {
      throw new SerieException(
          "Le libelle " + libelle + " existe déjà pour une serie !");
    }
  }
}
