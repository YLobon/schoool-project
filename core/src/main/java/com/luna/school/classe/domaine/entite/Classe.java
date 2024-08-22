package com.luna.school.classe.domaine.entite;

import com.luna.school.classe.domaine.objetvaleur.Cycle;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class Classe {

  private UUID id;
  private String libelle;
  private Serie serie;
  private Niveau niveau;
  private Cycle cycle;
  private Enseignant professeurPrincipal;
  private List<Etudiant> etudiants;
  private List<Matiere> matieres;
}
