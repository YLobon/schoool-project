package com.luna.school.repository.impl;

import com.luna.school.entite.SerieTable;
import com.luna.school.mapper.SerieMapper;
import com.luna.school.repository.JpaSerieRepository;
import com.luna.school.serie.application.exception.SerieException;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.application.vm.SerieVM;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 5:38 p.m..
 */
@Repository
public class PgSerieRepositoryAdapteur implements SerieRepositoryPort {
private final JpaSerieRepository jpaSerieRepository;
private final SerieMapper serieMapper;

  public PgSerieRepositoryAdapteur(JpaSerieRepository jpaSerieRepository) {
    this.jpaSerieRepository = jpaSerieRepository;
    this.serieMapper = SerieMapper.INSTANCE;
  }

  @Override
  public boolean existeParLibelle(String libelle) {
    return this.jpaSerieRepository.existsByLibelle(libelle);
  }

  @Override
  public void enregistrer(Serie serie) {
    SerieTable serieTable = this.serieMapper.serieVersSerieTable(serie);
    this.jpaSerieRepository.save(serieTable);
  }

  @Override
  public List<SerieVM> lister() {
    return this.jpaSerieRepository.findAll().stream().map(
        this.serieMapper::serieTableVersSerieVM
    ).collect(Collectors.toList());
  }

  @Override
  public Serie recupererParId(UUID id) {
    SerieTable serieTable = this.jpaSerieRepository.findById(id).orElseThrow(
        () -> new SerieException("La serie est introuvable !")
    );
    return this.serieMapper.serieTableVersSerie(serieTable);
  }

  @Override
  public void supprimer(UUID serieId) {
    try {
      this.jpaSerieRepository.deleteById(serieId);
    } catch (Exception e) {
      String message = "Impossible de suppreimer cette serie";
      throw new SerieException(message);
    }

  }
}
