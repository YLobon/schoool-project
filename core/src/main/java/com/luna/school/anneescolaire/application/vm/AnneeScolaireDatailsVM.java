package com.luna.school.anneescolaire.application.vm;

import java.time.LocalDate;
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
public class AnneeScolaireDatailsVM {
  private UUID id;
  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;
}
