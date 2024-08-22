package com.luna.school.anneescolaire.domaine.entite;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-18
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AnneeScolaire {

  private UUID id;
  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;

  public boolean anneePrecedente(){
    LocalDate curentDate = LocalDate.now();
    return this.dateFin.isAfter(curentDate);
  }

}
