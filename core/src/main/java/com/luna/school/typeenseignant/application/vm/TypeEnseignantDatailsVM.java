package com.luna.school.typeenseignant.application.vm;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-21
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeEnseignantDatailsVM {

  private UUID id;
  private String libelle;
  private double SalaireParHeure;
  private double taxe;
}
