package com.luna.school.note.domaine.entite;

import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-09 8:57 p.m..
 */
@Setter
@Getter
public class Note {

  private UUID id;
  private double note;
  private double bareme;
  private Etudiant etudiant;
  private Classe classe;
  private Trimestre trimestre;
  private Enseignant enseignant;
  private Matiere matiere;
}
