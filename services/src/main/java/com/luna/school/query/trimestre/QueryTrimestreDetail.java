package com.luna.school.query.trimestre;

import com.luna.school.entite.TrimestreTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.TrimestreMapper;
import com.luna.school.repository.JpaTrimestreRepository;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
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
public class QueryTrimestreDetail implements GestionnaireRequete<TrimestreDetailVM, UUID> {
private final JpaTrimestreRepository jpaTrimestreRepository;
private final TrimestreMapper trimestreMapper;

  public QueryTrimestreDetail(JpaTrimestreRepository jpaTrimestreRepository) {
    this.jpaTrimestreRepository = jpaTrimestreRepository;
    this.trimestreMapper = TrimestreMapper.INSTANCE;
  }

  @Override
  public TrimestreDetailVM requete(UUID id) {
    Optional<TrimestreTable> optionalTrimestreTable = this.jpaTrimestreRepository.findById(id);
    if (optionalTrimestreTable.isPresent()) {
      var anneeScolaireTable = optionalTrimestreTable.get();
      var campagneDetailsVM = this.trimestreMapper
          .trimestreTableTAbleVersTrimestreDetailVM(anneeScolaireTable);
      return campagneDetailsVM;
    }
    throw new NonTrouveException(
        "L'année  avec l'identifiant est " + id + " est introuvable !");
  }

}
