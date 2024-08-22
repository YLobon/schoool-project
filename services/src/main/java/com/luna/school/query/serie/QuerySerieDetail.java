package com.luna.school.query.serie;

import com.luna.school.entite.SerieTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.SerieMapper;
import com.luna.school.repository.JpaSerieRepository;
import com.luna.school.serie.application.vm.SerieVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QuerySerieDetail implements GestionnaireRequete<SerieVM, UUID> {
  private final JpaSerieRepository jpaSerieRepository;
  private final SerieMapper serieMapper;

  public QuerySerieDetail(JpaSerieRepository jpaSerieRepository) {
    this.jpaSerieRepository = jpaSerieRepository;
    serieMapper = SerieMapper.INSTANCE;
  }

  @Override
  public SerieVM requete(UUID id) {
    Optional<SerieTable> serieTableOptional = this.jpaSerieRepository.findById(id);
    if (serieTableOptional.isPresent()) {
      var serieTable = serieTableOptional.get();
      SerieVM serieVM = this.serieMapper
          .serieTableVersSerieVM(serieTable);
      return serieVM;
    }
    throw new NonTrouveException(
        "La serie  avec l'identifiant est " + id + " est introuvable !");
  }

}
