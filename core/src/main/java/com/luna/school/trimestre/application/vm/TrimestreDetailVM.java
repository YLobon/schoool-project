package com.luna.school.trimestre.application.vm;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-23
 */
@Getter
@Setter
public class TrimestreDetailVM {

  private UUID id;
  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;
  private UUID anneeScolaireId;

}
