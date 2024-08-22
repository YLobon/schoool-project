package com.luna.school.repository;

import com.luna.school.entite.PaysTable;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Repository pour la persistance des {@link PaysTable}.</p>
 *
 * @author BOUA YVES
 */
public interface JpaPaysRepository extends JpaRepository<PaysTable, UUID> {

  Optional<PaysTable> findByNom(String nom);
  boolean existsByNom(String nom);
}
