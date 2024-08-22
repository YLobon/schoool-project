package com.luna.school.repository;

import com.luna.school.entite.ParentEtudiantTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @author BOUA YVES 2024-06-15 10:11 a.m..
 */
public interface JpaParentEtudiantRepository extends JpaRepository<ParentEtudiantTable, UUID> {

}
