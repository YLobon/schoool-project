package com.luna.school.query.enseignant;

import com.luna.school.enseignant.application.vm.EnseignantEssentielVM;
import com.luna.school.entite.EnseignantTable;
import com.luna.school.mapper.EnseignantMapper;
import com.luna.school.repository.JpaEnseignantRepository;
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
public class QueryListeEnseignant implements
    GestionnaireRequete<List<EnseignantEssentielVM>, Void> {

  private final JpaEnseignantRepository jpaEnseignantRepository;
  private final EnseignantMapper enseignantMapper;

  public QueryListeEnseignant(JpaEnseignantRepository jpaEnseignantRepository) {
    this.jpaEnseignantRepository = jpaEnseignantRepository;
    enseignantMapper = EnseignantMapper.INSTANCE;
  }

  @Override
  public List<EnseignantEssentielVM> requete(Void var1) {
    List<EnseignantTable> enseignantTables = this.jpaEnseignantRepository.findAll();
    return enseignantTables.stream()
        .map(this.enseignantMapper::enseignantTableVersEnseignantEssentielVM)
        .collect(Collectors.toList());
  }
}
