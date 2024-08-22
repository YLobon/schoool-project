package com.luna.school.repository.impl;

import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.mapper.TypeEnseignantMapper;
import com.luna.school.repository.JpaTypeEnseignantRepository;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import com.luna.school.typeenseignant.domaine.entite.TypeEnseignant;
import com.luna.school.typeenseignant.domaine.exception.TypeEnseignantExeption;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-17 1:25 p.m..
 */
@Repository
@Transactional
public class PgTypeEnseignantRepositoryAdapteur implements TypeEnseignantRepositoryPort {
private final JpaTypeEnseignantRepository jpaTypeEnseignantRepository;
private final TypeEnseignantMapper typeEnseignantMapper;

  public PgTypeEnseignantRepositoryAdapteur(JpaTypeEnseignantRepository jpaTypeEnseignantRepository) {
    this.jpaTypeEnseignantRepository = jpaTypeEnseignantRepository;
    typeEnseignantMapper = TypeEnseignantMapper.INSTANCE;
  }

  @Override
  public boolean existeParLibelle(String libelle) {
    return this.jpaTypeEnseignantRepository.existsByLibelle(libelle);
  }

  @Override
  public void enregistrer(TypeEnseignant typeEnseignant) {
    TypeEnseignantTable typeEnseignantTable = this.typeEnseignantMapper
        .typeEnseignantVersTypeEnseignantTable(typeEnseignant);
    this.jpaTypeEnseignantRepository.save(typeEnseignantTable);
  }

  @Override
  public Optional<TypeEnseignant> recupererParId(UUID id) {
    Optional<TypeEnseignantTable> typeEnseignantTable = this.jpaTypeEnseignantRepository.findById(id);
    return this.optionnalTypeEnseignant(typeEnseignantTable);
  }

  private Optional<TypeEnseignant> optionnalTypeEnseignant(Optional<TypeEnseignantTable> optionalTypeEnseignantTable) {
    return optionalTypeEnseignantTable.map(this.typeEnseignantMapper::typeEnseignantTableVersTypeEnseignant);
  }

  @Override
  public void supprimer(UUID typeEnseignantId) {
    try {
      this.jpaTypeEnseignantRepository.deleteById(typeEnseignantId);
    } catch (Exception e) {
      String message = "Impossible de supprimer ce type d'enseignant !";
      throw new TypeEnseignantExeption(message);
    }
  }
}
