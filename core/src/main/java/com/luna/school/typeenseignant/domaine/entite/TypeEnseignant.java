package com.luna.school.typeenseignant.domaine.entite;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-17 12:50 p.m..
 */
@Getter
@Setter
public class TypeEnseignant {
  private UUID id;
  private String libelle;
  private double SalaireParHeure;
  private double taxe;

}
