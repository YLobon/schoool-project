package com.luna.school.repository;

import com.luna.school.entite.TrimestreTable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:15 a.m..
 */
public interface JpaTrimestreRepository extends JpaRepository<TrimestreTable, UUID> {

  boolean existsByLibelle(String libelle);

  List<TrimestreTable> findByAnneeScolaireId(UUID anneeScolaireId);
}
