package com.luna.school.repository;

import com.luna.school.entite.SousMatiereTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 9:14 a.m..
 */
public interface JpaSousMatiereRepository extends JpaRepository<SousMatiereTable, UUID> {

  boolean existsByNomSousMatiere(String nomSousMatiere);

  boolean existsById(UUID id);
}
