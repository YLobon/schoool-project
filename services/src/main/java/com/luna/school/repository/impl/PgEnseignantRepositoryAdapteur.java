package com.luna.school.repository.impl;

import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.entite.EnseignantTable;
import com.luna.school.mapper.EnseignantMapper;
import com.luna.school.repository.JpaEnseignantRepository;
import com.luna.school.typeenseignant.domaine.exception.TypeEnseignantExeption;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @author BOUA YVES 2024-06-17 5:11 p.m..
 */
@Repository
@Transactional
public class PgEnseignantRepositoryAdapteur implements EnseignantRepositoryPort {
private final JpaEnseignantRepository jpaEnseignantRepository;
private final EnseignantMapper enseignantMapper;

  public PgEnseignantRepositoryAdapteur(JpaEnseignantRepository jpaEnseignantRepository) {
    this.jpaEnseignantRepository = jpaEnseignantRepository;
    enseignantMapper = EnseignantMapper.INSTANCE;
  }

  @Override
  public boolean matriculeExiste(String matricule) {
    return this.jpaEnseignantRepository.existsByMatricule(matricule);
  }

  @Override
  public void enregistrer(Enseignant enseignant) {
    EnseignantTable enseignantTable = this.enseignantMapper
        .enseignantVersEnseignantTable(enseignant);
    this.jpaEnseignantRepository.save(enseignantTable);
  }

  @Override
  public Enseignant recupererParId(UUID id) {
    Optional<EnseignantTable> enseignantTableOptional = this.jpaEnseignantRepository.findById(id);
    if (enseignantTableOptional.isPresent()){
      EnseignantTable enseignantTable = enseignantTableOptional.get();
      return this.enseignantMapper.enseignantTableVersEnseignant(enseignantTable);
    }else {
      throw new EnseignantException("L'enseignant avec cet identifiant est introuvable!");
    }
  }

  @Override
  public void supprimer(UUID enseignantId) {
    try {
      this.jpaEnseignantRepository.deleteById(enseignantId);
    } catch (Exception e) {
      String message = "Impossible de supprimer cet enseignant !";
      throw new TypeEnseignantExeption(message);
    }
  }
}
