package com.luna.school.note.application.vm;

import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.personnel.domaine.entite.Personnel;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-09 10:12 p.m..
 */
@Getter
@Setter
public class NoteDetailVM {

  private UUID id;
  private double note;
  private double bareme;
  private Etudiant etudiant;
  private Classe classe;
  private Trimestre trimestre;
  private Personnel personnel;
  private Matiere matiere;
}
