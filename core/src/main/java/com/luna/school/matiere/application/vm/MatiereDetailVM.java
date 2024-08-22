package com.luna.school.matiere.application.vm;

import com.luna.school.matiere.domaine.entite.SousMatiere;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 9:10 a.m..
 */
@Getter
@Setter
public class MatiereDetailVM {

  private UUID id;
  private String nom;
  private double coefficient;
  private boolean sousMatiere;
  private double note;
  private List<SousMatiere> sousMatieres;
}
