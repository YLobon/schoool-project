package com.luna.school.repository.impl;

import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.entite.EtudiantTable;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.mapper.EtudiantMapper;
import com.luna.school.repository.JpaEtudianRepository;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @author BOUA YVES 2024-06-15 10:42 a.m..
 */
@Repository
@Transactional
public class PgEtudiantRepositoryAdapteur implements EtudiantRepositoryPort {
private final JpaEtudianRepository jpaEtudianRepository;
private final EtudiantMapper etudiantMapper;

  public PgEtudiantRepositoryAdapteur(JpaEtudianRepository jpaEtudianRepository) {
    this.jpaEtudianRepository = jpaEtudianRepository;
    etudiantMapper = EtudiantMapper.INSTANCE;
  }

  @Override
  public boolean matriculeExiste(String matricule) {
    return this.jpaEtudianRepository.existsByMatricule(matricule);
  }

  @Override
  public void enregistrer(Etudiant etudiant) {
    EtudiantTable etudiantTable = this.etudiantMapper.etudiantVersEtudiantTable(etudiant);
    this.jpaEtudianRepository.save(etudiantTable);
  }

  @Override
  public Etudiant recupererParId(UUID id) {
    Optional<EtudiantTable> etudiantTableOptional = this.jpaEtudianRepository.findById(id);
    if (etudiantTableOptional.isPresent()){
      EtudiantTable etudiantTable = etudiantTableOptional.get();
      return this.etudiantMapper.etudiantTableVersEtudiant(etudiantTable);
    }else {
      throw new ClasseExecption("L'étudiant est introuvable !");
    }
  }
}
