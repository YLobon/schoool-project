package com.luna.school.comptabilite.application.commande;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 7:56 p.m..
 */
@Getter
@Setter
public class PayerScolariteCommande {

  private String libelle;
  private LocalDate datePaiement;
  private BigDecimal montantVerset;
  private UUID etudiantId;
}
