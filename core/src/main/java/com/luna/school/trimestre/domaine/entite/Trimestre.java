package com.luna.school.trimestre.domaine.entite;

import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-21
 */
@Getter
@Setter
public class Trimestre {

  private UUID id;
  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;
  private boolean encours;
  private AnneeScolaire anneeScolaire;

  public boolean demarer() {
    LocalDate current = LocalDate.now();
    return !current.isBefore(dateDebut);
  }
}
