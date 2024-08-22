package com.luna.school.repository;

import com.luna.school.entite.PermissionPersonnelTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-22 12:40 p.m..
 */
public interface JpaPermissionPersonnelRepository extends JpaRepository<PermissionPersonnelTable, UUID> {

}
