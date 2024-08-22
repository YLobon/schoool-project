package com.luna.school.etudiant.application.vm;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.Statut;
import com.luna.school.etudiant.domaine.entite.ParentEtudiant;
import com.luna.school.pays.domaine.entite.Pays;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 10:45 a.m..
 */
@Getter
@Setter
public class EtudiantEssentielVM {

  private Civilite civilite;
  private Statut statut;
  private boolean boursier;
  private String matricule;
  private String nom;
  private String prenoms;
  private LocalDate dateNaissance;
  private String lieuNaissance;
  private Pays nationnailite;
  private String residence;
  private String contact;
  private String contactUrgence;
  private String descriptionProbleSante;
  private boolean orphelinDesDeuxParent;
  private boolean orphelinDeMere;
  private boolean orphelinDesDePere;
  private ParentEtudiant tuteur;
  private ParentEtudiant pere;
  private ParentEtudiant mere;
}
