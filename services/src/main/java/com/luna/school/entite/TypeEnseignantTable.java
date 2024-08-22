package com.luna.school.entite;

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
 * @Author BOUA YVES 2024-05-30 5:42 p.m..
 */
@Getter
@Setter
@Entity
@Table(name = "type-enseignant")
public class TypeEnseignantTable {

  @Id
  private UUID id;
  private String libelle;
  private double SalaireParHeure;
  private double taxe;
}
