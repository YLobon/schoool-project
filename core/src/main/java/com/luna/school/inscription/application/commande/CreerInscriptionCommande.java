package com.luna.school.inscription.application.commande;

import com.luna.school.etudiant.application.gestionnairecommande.CreerEtudiantCommende;
import com.luna.school.etudiant.domaine.objetvaleur.DecisionFinAnnee;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class CreerInscriptionCommande {

  private boolean boursier;
  private boolean redouble;
  private UUID idMatiereFacultatif;
  private UUID classePrecedanteId;
  private UUID classeActuelleId;
  private LocalDate dateInscription;
  private LocalDate datePaiement;
  private boolean releveNote;
  private boolean deposerPhoto;
  private boolean droitInscription;
  private boolean fairePremierVersement;
  private BigDecimal montantVerset;
  private boolean extraitNaisaance;
  private String numeroExtraitNaissance;
  private String etablissementPrecedante;
  private CreerEtudiantCommende creerEtudiantCommende;
  private DecisionFinAnnee decisionFinAnnee;
}
