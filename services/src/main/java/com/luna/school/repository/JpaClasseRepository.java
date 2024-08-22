package com.luna.school.repository;

import com.luna.school.entite.ClasseTable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-01 1:05 p.m..
 */
public interface JpaClasseRepository extends JpaRepository<ClasseTable, UUID> {

  @Override
  boolean existsById(UUID uuid);
  boolean existsByLibelle(String libelle);

  List<ClasseTable> findByNiveauId(UUID niveauId);

}
