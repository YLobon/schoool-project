package com.luna.school.examen.domaine.entite;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-29 7:36 p.m..
 */
@Getter
@Setter
public class MatiereExamen {
  private UUID id;
  private String nom;
  private double coefficient;
}
