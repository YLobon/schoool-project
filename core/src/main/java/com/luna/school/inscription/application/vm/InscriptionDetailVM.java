package com.luna.school.inscription.application.vm;

import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.etudiant.domaine.objetvaleur.DecisionFinAnnee;
import com.luna.school.matiere.domaine.entite.Matiere;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 6:49 a.m..
 */
@Getter
@Setter
public class InscriptionDetailVM {

  private UUID id;
  private boolean boursier;
  private LocalDate dateInscription;
  private String lieuNaissance;
  private String etablissementPrecedante;
  private Classe classePrecedante;
  private Classe classeActuelle;
  private double moyenneAnnuellePrecedante;
  private DecisionFinAnnee decisionFinAnnee;
  private boolean redouble;
  private Matiere matiereFacultatif;
  private TypePiece piece;
  private String numeroPiece;
  private boolean extraitNaisaance;
  private String numeroExtraitNaissance;
  private boolean releveNote;
  private boolean deposerPhoto;
  private boolean droitInscription;
  private boolean fairePremierVersement;
  private Etudiant etudiant;
}
