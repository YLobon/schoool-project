package com.luna.school.repository;

import com.luna.school.entite.EnseignantTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-17 3:36 p.m..
 */
public interface JpaEnseignantRepository extends JpaRepository<EnseignantTable, UUID> {

  boolean existsByMatricule(String matricule);
}
