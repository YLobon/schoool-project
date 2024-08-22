package com.luna.school.repository;

import com.luna.school.entite.PersonnelTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 11:23 p.m..
 */
public interface JpaPersonnelRepository extends JpaRepository<PersonnelTable, UUID> {
boolean existsByMatricule(String matricule);
}
