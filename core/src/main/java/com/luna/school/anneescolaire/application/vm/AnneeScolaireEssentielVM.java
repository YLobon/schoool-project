package com.luna.school.anneescolaire.application.vm;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-21
 */
@Getter
@Setter
public class AnneeScolaireEssentielVM {
  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;
}
