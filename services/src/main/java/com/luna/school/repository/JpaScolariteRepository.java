package com.luna.school.repository;

import com.luna.school.entite.ScolariteTable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 10:49 p.m..
 */
public interface JpaScolariteRepository extends JpaRepository<ScolariteTable, UUID> {

  boolean existsByLibelle(String libelle);

  boolean existsByEtudiantId(UUID etudiantId);

  List<ScolariteTable> findByEtudiantId(UUID etudiantId);
}
