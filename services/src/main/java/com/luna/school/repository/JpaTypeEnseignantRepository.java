package com.luna.school.repository;

import com.luna.school.entite.TypeEnseignantTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-17 1:24 p.m..
 */
public interface JpaTypeEnseignantRepository extends JpaRepository<TypeEnseignantTable, UUID> {

  boolean existsByLibelle(String libelle);
}
