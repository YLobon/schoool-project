package com.luna.school.repository.impl;

import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.entite.ParentEtudiantTable;
import com.luna.school.etudiant.application.port.ParentEtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.ParentEtudiant;
import com.luna.school.mapper.ParentEtudiantMapper;
import com.luna.school.repository.JpaParentEtudiantRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 5:30 p.m..
 */
@Repository
@Transactional
public class PgParentEtudiantRepositoryAdapteur implements ParentEtudiantRepositoryPort {

  private final JpaParentEtudiantRepository jpaParentEtudiantRepository;
  private final ParentEtudiantMapper parentEtudiantMapper;

  public PgParentEtudiantRepositoryAdapteur(
      JpaParentEtudiantRepository jpaParentEtudiantRepository) {
    this.jpaParentEtudiantRepository = jpaParentEtudiantRepository;
    parentEtudiantMapper = ParentEtudiantMapper.INSTANCE;
  }

  @Override
  public void enregistrer(ParentEtudiant pereEtudiant) {
    ParentEtudiantTable parentEtudiantTable =
        this.parentEtudiantMapper.parentEtudiantVersParentEtudiantTable(
            pereEtudiant);
    this.jpaParentEtudiantRepository.save(parentEtudiantTable);
  }

  @Override
  public ParentEtudiant recupererParId(UUID id) {
    Optional<ParentEtudiantTable> parentEtudiantTableOptional =
        this.jpaParentEtudiantRepository.findById(id);
    if (parentEtudiantTableOptional.isPresent()) {
      ParentEtudiantTable parentEtudiantTable = parentEtudiantTableOptional.get();
      return this.parentEtudiantMapper.parentEtudiantTableVersParentEtudiant(parentEtudiantTable);
    } else {
      throw new ClasseExecption("Ce parent est introuvable !");
    }
  }
}
