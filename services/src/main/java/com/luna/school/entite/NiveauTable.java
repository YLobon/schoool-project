package com.luna.school.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 5:42 p.m..
 */
@Getter
@Setter
@Entity
@Table(name = "niveau")
public class NiveauTable {

  @Id
  private UUID id;
  @Column(nullable = false)
  private String nom;
  @ManyToOne
  @JoinColumn(name = "educateur_id", nullable = false)
  private PersonnelTable educateur;
  @Column(nullable = false)
  private BigDecimal montantScolarite;
}


