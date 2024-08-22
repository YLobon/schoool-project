package com.luna.school.permission.application.vm;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-22 12:44 p.m..
 */
@Getter
@Setter
public class PermissionEtudiantVM {

  private LocalDate dateDebut;
  private LocalDate dateFin;
  private String description;
  private String etudiant;
  private int age;
}
