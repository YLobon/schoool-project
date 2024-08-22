package com.luna.school.repository;

import com.luna.school.entite.InscriptionTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 6:40 a.m..
 */
public interface JpaInscriptionRepository extends JpaRepository<InscriptionTable, UUID> {

  InscriptionTable findByEtudiantId(UUID etudiantId);
}
