package com.luna.school.query.scolarite;

import com.luna.school.comptabilite.application.vm.ScolariteDetailsVM;
import com.luna.school.entite.ScolariteTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.ScolariteMapper;
import com.luna.school.repository.JpaScolariteRepository;
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
public class QueryScolariteDetail implements GestionnaireRequete<ScolariteDetailsVM, UUID> {

  private final JpaScolariteRepository jpaScolariteRepository;
  private final ScolariteMapper scolariteMapper;

  public QueryScolariteDetail(JpaScolariteRepository jpaScolariteRepository) {
    this.jpaScolariteRepository = jpaScolariteRepository;
    scolariteMapper = ScolariteMapper.INSTANCE;
  }

  @Override
  public ScolariteDetailsVM requete(UUID id) {
    Optional<ScolariteTable> scolariteTableOptional = this.jpaScolariteRepository.findById(id);
    if (scolariteTableOptional.isPresent()) {
      var matiereTable = scolariteTableOptional.get();
      var matiereDetailsVM = this.scolariteMapper
          .scolariteTableVersScolariteDetailsVM(matiereTable);
      return matiereDetailsVM;
    }
    throw new NonTrouveException(
        "La scolarité avec l'identifiant est " + id + " est introuvable !");
  }

}
