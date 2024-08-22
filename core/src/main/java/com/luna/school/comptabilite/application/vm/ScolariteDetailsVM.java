package com.luna.school.comptabilite.application.vm;

import com.luna.school.etudiant.domaine.entite.Etudiant;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 10:41 p.m..
 */
@Setter
@Getter
public class ScolariteDetailsVM {

  private UUID id;
  private String libelle;
  private LocalDate datePaiement;
  private BigDecimal ScolariteTotale;
  private BigDecimal montantVerset;
  private BigDecimal reste;
  private Etudiant etudiant;
}
