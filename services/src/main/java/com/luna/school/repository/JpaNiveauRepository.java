package com.luna.school.repository;

import com.luna.school.entite.NiveauTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 11:06 p.m..
 */
public interface JpaNiveauRepository extends JpaRepository<NiveauTable, UUID> {

  boolean existsByNom(String nom);
}
