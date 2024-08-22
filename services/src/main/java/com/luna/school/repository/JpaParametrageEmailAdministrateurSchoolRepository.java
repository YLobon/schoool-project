package com.luna.school.repository;

import com.luna.school.luna.ParametrageEmailAdministrateurSchoolTable;
import com.luna.school.luna.TypeAdministrateurLuna;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-23 8:05 a.m..
 */
public interface JpaParametrageEmailAdministrateurSchoolRepository extends
    JpaRepository<ParametrageEmailAdministrateurSchoolTable, UUID> {

  boolean existsByEmailAndType(String email, TypeAdministrateurLuna type);
}
