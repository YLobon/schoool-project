package com.luna.school.repository;

import com.luna.school.entite.SerieTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 5:39 p.m..
 */
public interface JpaSerieRepository extends JpaRepository<SerieTable, UUID> {
boolean existsByLibelle(String libelle);
}
