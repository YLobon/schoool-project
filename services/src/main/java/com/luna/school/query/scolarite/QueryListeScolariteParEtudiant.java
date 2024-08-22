package com.luna.school.query.scolarite;

import com.luna.school.comptabilite.application.vm.ScolariteDetailsVM;
import com.luna.school.entite.ScolariteTable;
import com.luna.school.mapper.ScolariteMapper;
import com.luna.school.repository.JpaScolariteRepository;
import com.luna.school.tools.GestionnaireRequete;
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
public class QueryListeScolariteParEtudiant implements
    GestionnaireRequete<List<ScolariteDetailsVM>, UUID> {

  private final JpaScolariteRepository jpaScolariteRepository;
  private final ScolariteMapper scolariteMapper;

  public QueryListeScolariteParEtudiant(JpaScolariteRepository jpaScolariteRepository) {
    this.jpaScolariteRepository = jpaScolariteRepository;
    scolariteMapper = ScolariteMapper.INSTANCE;
  }

  @Override
  public List<ScolariteDetailsVM> requete(UUID etudiantId) {
    List<ScolariteTable> scolariteTableList = this.jpaScolariteRepository
        .findByEtudiantId(etudiantId);
    return scolariteTableList.stream()
        .map(this.scolariteMapper::scolariteTableVersScolariteDetailsVM).toList();
  }
}
