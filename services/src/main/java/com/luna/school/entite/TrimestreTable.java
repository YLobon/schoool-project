package com.luna.school.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-21
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "trimestre")
public class TrimestreTable {

  @Id
  private UUID id;
  @Column(nullable = false)
  private String libelle;
  @Column(nullable = false)
  private LocalDate dateDebut;
  @Column(nullable = false)
  private boolean encours;
  @Column(nullable = false)
  private LocalDate dateFin;
  @ManyToOne
  private AnneeScolaireTable anneeScolaire;
}
