package com.luna.school.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 10:42 p.m..
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "scolarite")
public class ScolariteTable {

  @Id
  private UUID id;
  private String libelle;
  @Column(nullable = false)
  private LocalDate datePaiement;
  @Column(nullable = false)
  private BigDecimal ScolariteTotale;
  @Column(nullable = false)
  private BigDecimal montantVerset;
  @Column(nullable = false)
  private BigDecimal reste;
  @ManyToOne
  @JoinColumn(name = "etudiant_id", nullable = false)
  private EtudiantTable etudiant;
}
