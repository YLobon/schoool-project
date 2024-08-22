package com.luna.school.trimestre.application.vm;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-23
 */
@Getter
@Setter
public class TrimestreEssentielVM {

  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;

}
