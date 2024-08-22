package com.luna.school.serie.application.port;

import com.luna.school.serie.application.vm.SerieVM;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-02
 */
public interface SerieRepositoryPort {

  boolean existeParLibelle(String libelle);

  void enregistrer(Serie serie);

  List<SerieVM> lister();

  Serie recupererParId(UUID id);

  void supprimer(UUID serieId);
}
