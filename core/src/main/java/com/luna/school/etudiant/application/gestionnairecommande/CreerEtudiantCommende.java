package com.luna.school.etudiant.application.gestionnairecommande;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.Statut;
import com.luna.school.pays.domaine.entite.Pays;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class CreerEtudiantCommende {
  private Civilite civilite;
  private Statut statut;
  private boolean boursier;
  private String matricule;
  private String nom;
  private String prenoms;
  private LocalDate dateNaissance;
  private String lieuNaissance;
  private String etablissementPrecedante;
  private Pays nationnailite;
  private String residence;
  private String contact;
  private String descriptionProbleSante;
  private boolean orphelinDesDeuxParent;
  private boolean orphelinDeMere;
  private boolean orphelinDesDePere;
  private CreerParentMereEtudiantCommande parentMereCommande;
  private CreerPereEtudiantCommande parentPereCommande;
  private CreerTuTeurEtudiantCommande tuTeurEtudiantCommande;

}
