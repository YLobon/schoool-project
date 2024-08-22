package com.luna.school.salaire.domaine.entite;

import com.luna.school.personnel.domaine.entite.Personnel;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-02
 */
@Getter
@Setter
public class Salaire {
  private UUID id;
  private LocalDate datePaie;
  private boolean estPayer;
  private Personnel personnel;
}
