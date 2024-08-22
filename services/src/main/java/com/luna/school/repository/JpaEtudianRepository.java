package com.luna.school.repository;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.enumeration.Civilite;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 7:06 a.m..
 */
public interface JpaEtudianRepository extends JpaRepository<EtudiantTable, UUID> {

  boolean existsByMatricule(String matricule);

  List<EtudiantTable> findByCivilite(Civilite civilite);
}
