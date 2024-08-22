package com.luna.school.query.serie;

import com.luna.school.entite.SerieTable;
import com.luna.school.mapper.SerieMapper;
import com.luna.school.repository.JpaSerieRepository;
import com.luna.school.serie.application.vm.SerieVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListeSerie implements GestionnaireRequete<List<SerieVM>, Void> {
private final JpaSerieRepository jpaSerieRepository;
private final SerieMapper serieMapper;

  public QueryListeSerie(JpaSerieRepository jpaSerieRepository) {
    this.jpaSerieRepository = jpaSerieRepository;
    serieMapper = SerieMapper.INSTANCE;
  }


  @Override
  public List<SerieVM> requete(Void var1){
    List<SerieTable> serieTableList = this.jpaSerieRepository.findAll();
    return serieTableList.stream().map(this.serieMapper::serieTableVersSerieVM)
        .collect(Collectors.toList());
  }
}
