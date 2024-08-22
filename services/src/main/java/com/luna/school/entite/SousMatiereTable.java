package com.luna.school.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-01 3:21 p.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sous_matiere")
public class SousMatiereTable {

  @Id
  private UUID id;
  private String nomSousMatiere;
  private double note;
  @ManyToOne
  @JoinColumn(name = "matiere_id", nullable = true)
  private MatiereTable matiere;
}
