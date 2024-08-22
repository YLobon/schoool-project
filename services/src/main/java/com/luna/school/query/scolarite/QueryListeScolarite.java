package com.luna.school.query.scolarite;

import com.luna.school.comptabilite.application.vm.ScolariteEssentielVM;
import com.luna.school.entite.ScolariteTable;
import com.luna.school.mapper.ScolariteMapper;
import com.luna.school.repository.JpaScolariteRepository;
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
public class QueryListeScolarite implements GestionnaireRequete<List<ScolariteEssentielVM>, Void> {

  private final JpaScolariteRepository jpaScolariteRepository;
  private final ScolariteMapper scolariteMapper;

  public QueryListeScolarite(JpaScolariteRepository jpaScolariteRepository) {
    this.jpaScolariteRepository = jpaScolariteRepository;
    scolariteMapper = ScolariteMapper.INSTANCE;
  }

  @Override
  public List<ScolariteEssentielVM> requete(Void var1) {
    List<ScolariteTable> scolariteTables = this.jpaScolariteRepository.findAll();
    return scolariteTables.stream()
        .map(this.scolariteMapper::scolariteTableVersScolariteEssentielVM)
        .collect(Collectors.toList());
  }
}
