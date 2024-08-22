package com.luna.school.entite.examen;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @author BOUA YVES 2024-06-01 3:19 p.m..
 */
@Getter
@Setter
@Entity
@Table(name = "matiere_examen")
public class MatiereExamenTable {

  @Id
  private UUID id;
  private String nom;
  private double coefficient;
}
