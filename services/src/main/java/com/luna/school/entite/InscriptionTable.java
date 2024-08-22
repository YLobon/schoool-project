package com.luna.school.entite;

import com.luna.school.enumeration.TypePiece;
import com.luna.school.etudiant.domaine.objetvaleur.DecisionFinAnnee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 6:33 a.m..
 */
@Getter
@Setter
@Entity
@Table(name = "inscription")
public class InscriptionTable {

  @Id
  private UUID id;
  @Column(nullable = false)
  private boolean boursier;
  @Column(nullable = false)
  private LocalDate dateInscription;
  @Column(nullable = false)
  private String lieuNaissance;
  @Column(nullable = false)
  private String etablissementPrecedante;
  @ManyToOne
  @JoinColumn(name = "classePrecedante_id", nullable = false)
  private ClasseTable classePrecedante;
  @ManyToOne
  @JoinColumn(name = "classeActuelle_id", nullable = false)
  private ClasseTable classeActuelle;
  @Column(nullable = false)
  private double moyenneAnnuellePrecedante;
  @Enumerated(EnumType.STRING)
  private DecisionFinAnnee decisionFinAnnee;
  @Column(nullable = false)
  private boolean redouble;
  @ManyToOne
  @JoinColumn(name = "matiereFacultatif_id", nullable = false)
  private MatiereTable matiereFacultatif;
  @Enumerated(EnumType.STRING)
  private TypePiece piece;
  private String numeroPiece;
  @Column(nullable = false)
  private boolean extraitNaisaance;
  @Column(nullable = false)
  private String numeroExtraitNaissance;
  @Column(nullable = false)
  private boolean releveNote;
  @Column(nullable = false)
  private boolean deposerPhoto;
  @Column(nullable = false)
  private boolean droitInscription;
  @Column(nullable = false)
  private boolean fairePremierVersement;
  @ManyToOne
  @JoinColumn(name = "etudiant_id", nullable = false)
  private EtudiantTable etudiant;
  @ManyToOne
  @JoinColumn(name = "scolarite_id", nullable = false)
  private ScolariteTable scolarite;

}
