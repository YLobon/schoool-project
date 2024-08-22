package com.luna.school.repository;

import com.luna.school.entite.PermissionEnseignantTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-22 12:42 p.m..
 */
public interface JpaPermissionEnseignantRepository extends JpaRepository<PermissionEnseignantTable, UUID> {

}
