package com.luna.school.etudiant.domaine.entite;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.Statut;
import com.luna.school.pays.domaine.entite.Pays;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA Jules 2024-03-27
 */
@Getter
@Setter
public class Etudiant {

  private UUID id;
  private Civilite civilite;
  private Statut statut;
  private boolean boursier;
  private String matricule;
  private String nom;
  private String prenoms;
  private String photo;
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

  public int calculerAge() {
    LocalDate maintenant = LocalDate.now();
    Period periode = Period.between(dateNaissance, maintenant);
    return periode.getYears();
  }
}
