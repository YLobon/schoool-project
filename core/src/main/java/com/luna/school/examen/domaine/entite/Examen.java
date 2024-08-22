package com.luna.school.examen.domaine.entite;

import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.examen.domaine.objetvaleur.TypeExamen;
import com.luna.school.niveau.domaine.entite.Niveau;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-18
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Examen {

  private UUID id;
  private String libelle;
  private Niveau niveau;
  private TypeExamen typeExamen;
  private List<Classe> classes;
  private List<Enseignant> enseignants;
  private List<Etudiant> etudiants;
  private Set<MatiereExamen> matieres;
  private LocalDate dateDebutComposition;
  private LocalDate dateFinComposition;

}
