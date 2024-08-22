package com.luna.school.query.trimestre;

import com.luna.school.entite.TrimestreTable;
import com.luna.school.mapper.TrimestreMapper;
import com.luna.school.repository.JpaTrimestreRepository;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListeTrimestreParAnnerScolaire implements
    GestionnaireRequete<List<TrimestreDetailVM>, UUID> {

  private final JpaTrimestreRepository jpaTrimestreRepository;
  private final TrimestreMapper trimestreMapper;

  public QueryListeTrimestreParAnnerScolaire(JpaTrimestreRepository jpaTrimestreRepository) {
    this.jpaTrimestreRepository = jpaTrimestreRepository;
    this.trimestreMapper = TrimestreMapper.INSTANCE;
  }

  @Override
  public List<TrimestreDetailVM> requete(UUID anneeScolaireId) {
    List<TrimestreTable> trimestreTableList = this.jpaTrimestreRepository
        .findByAnneeScolaireId(anneeScolaireId);
    return trimestreTableList.stream()
        .map(this.trimestreMapper::trimestreTableTAbleVersTrimestreDetailVM).toList();
  }
}
