package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.SerieQueryFacade;
import com.luna.school.query.serie.QueryListeSerie;
import com.luna.school.query.serie.QuerySerieDetail;
import com.luna.school.repository.JpaSerieRepository;
import com.luna.school.serie.application.vm.SerieVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class SerieQueryFacadeImpl implements SerieQueryFacade {
 private final GestionnaireRequete<List<SerieVM>,Void> gestionnaireListerSerie;
 private final GestionnaireRequete<SerieVM, UUID> gestionnaireRecupereParId;

  public SerieQueryFacadeImpl(JpaSerieRepository jpaSerieRepository) {
    gestionnaireRecupereParId = new QuerySerieDetail(jpaSerieRepository);
    gestionnaireListerSerie = new QueryListeSerie(
        jpaSerieRepository);
  }

  @Override
  public List<SerieVM> lister() {
    return this.gestionnaireListerSerie.requete(null);
  }

  @Override
  public SerieVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }
}
