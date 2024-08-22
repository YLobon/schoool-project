package com.luna.school.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-21 10:12 p.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "permission-enseignant")
public class PermissionEnseignantTable {

  @Id
  private UUID id;
  private LocalDate dateDebut;
  private LocalDate dateFin;
  private String description;
  @ManyToOne
  @JoinColumn(name = "enseignant_id", nullable = false)
  private EnseignantTable enseignant;
}
