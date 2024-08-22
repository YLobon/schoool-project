package com.luna.school.entite;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-01 3:19 p.m..
 */
@Getter
@Setter
@Entity
@Table(name = "matiere")
public class MatiereTable {

  @Id
  private UUID id;
  private String nom;
  private double coefficient;
  private boolean sousMatiere;
  private double note;
  @OneToMany(mappedBy = "matiere")
  private List<SousMatiereTable> sousMatieres;
  @ManyToOne
  @JoinColumn(name = "classe_id")
  private ClasseTable classe;
}
