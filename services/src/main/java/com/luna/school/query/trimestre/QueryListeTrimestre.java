package com.luna.school.query.trimestre;

import com.luna.school.entite.TrimestreTable;
import com.luna.school.mapper.TrimestreMapper;
import com.luna.school.repository.JpaTrimestreRepository;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
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
public class QueryListeTrimestre implements GestionnaireRequete<List<TrimestreEssentielVM>, Void> {
  private final JpaTrimestreRepository jpaTrimestreRepository;
  private final TrimestreMapper trimestreMapper;

  public QueryListeTrimestre(JpaTrimestreRepository jpaTrimestreRepository) {
    this.jpaTrimestreRepository = jpaTrimestreRepository;
    trimestreMapper = TrimestreMapper.INSTANCE;
  }

  @Override
  public List<TrimestreEssentielVM> requete(Void var1){
    List<TrimestreTable> trimestreTables = this.jpaTrimestreRepository.findAll();
    return trimestreTables.stream().map(this.trimestreMapper::trimestreTableVersTrimestreEssentielVM)
        .collect(Collectors.toList());
  }
}
