package com.luna.school.comptabilite.application.vm;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 10:40 p.m..
 */

import com.luna.school.etudiant.domaine.entite.Etudiant;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScolariteEssentielVM {

  private String libelle;
  private LocalDate datePaiement;
  private BigDecimal ScolariteTotale;
  private BigDecimal montantVerset;
  private BigDecimal reste;
  private Etudiant etudiant;
}
