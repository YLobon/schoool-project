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
 * @Author BOUA YVES 2024-06-09 9:43 p.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "note")
public class NoteTable {

  @Id
  private UUID id;
  private double bareme;
  private double note;
  @ManyToOne
  @JoinColumn(name = "etudiant_id",nullable = false)
  private EtudiantTable etudiant;
  @ManyToOne
  @JoinColumn(name = "classe_id",nullable = false)
  private ClasseTable classe;
  @ManyToOne
  @JoinColumn(name = "trimestre_id",nullable = false)
  private TrimestreTable trimestre;
  @ManyToOne
  @JoinColumn(name = "enseignant_id")
  private EnseignantTable enseignant;
  @ManyToOne
  @JoinColumn(name = "matiere_id",nullable = false)
  private MatiereTable matiere;
}
