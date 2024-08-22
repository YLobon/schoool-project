package com.luna.school.repository.impl;

import com.luna.school.comptabilite.application.port.ScolariteRepositoryPort;
import com.luna.school.comptabilite.domaine.entite.Scolarite;
import com.luna.school.comptabilite.domaine.exception.ScolariteException;
import com.luna.school.entite.ScolariteTable;
import com.luna.school.mapper.ScolariteMapper;
import com.luna.school.repository.JpaScolariteRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 10:52 p.m..
 */
@Repository
public class PgScolariteRepositoryAdapteur implements ScolariteRepositoryPort {
private final JpaScolariteRepository jpaScolariteRepository;
private final ScolariteMapper scolariteMapper;

  public PgScolariteRepositoryAdapteur(JpaScolariteRepository jpaScolariteRepository) {
    this.jpaScolariteRepository = jpaScolariteRepository;
    scolariteMapper = ScolariteMapper.INSTANCE;
  }

  @Override
  public boolean existsParLibelle(String libelle) {
    return this.jpaScolariteRepository.existsByLibelle(libelle);
  }

  @Override
  public void enregistrer(Scolarite scolarite) {
    ScolariteTable scolariteTable = this.scolariteMapper.scolariteVersScolariteTable(scolarite);
    this.jpaScolariteRepository.save(scolariteTable);
  }

  @Override
  public boolean existeParEtudiant(UUID etudiantId) {
    return this.jpaScolariteRepository.existsByEtudiantId(etudiantId);
  }

  @Override
  public Scolarite recupererParId(UUID id) {
    Optional<ScolariteTable> scolariteTableOptional = this.jpaScolariteRepository.findById(id);
    if(scolariteTableOptional.isPresent()){
      ScolariteTable scolariteTable = scolariteTableOptional.get();
      return this.scolariteMapper.scolariteTableVersScolarite(scolariteTable);
    }else {
      throw new ScolariteException("Cette scolarite est introuvable !");
    }
  }
}
