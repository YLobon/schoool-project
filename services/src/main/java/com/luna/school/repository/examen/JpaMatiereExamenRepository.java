package com.luna.school.repository.examen;

import com.luna.school.entite.examen.MatiereExamenTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-30 2:56 p.m..
 */
public interface JpaMatiereExamenRepository extends JpaRepository<MatiereExamenTable, UUID> {

}
