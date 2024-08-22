package com.luna.school.entite;


import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.Statut;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-01 11:40 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "etudiant")
public class EtudiantTable {

  @Id
  private UUID id;
  @Enumerated(EnumType.STRING)
  private Civilite civilite;
  @Enumerated(EnumType.STRING)
  private Statut statut;
  private boolean boursier;
  private String matricule;
  private String nom;
  private String prenoms;
  private String photo;
  private LocalDate dateNaissance;
  private String lieuNaissance;
  @ManyToOne
  @JoinColumn(name = "nationnailite_id", nullable = false)
  private PaysTable nationnailite;
  private String residence;
  private String contact;
  private String contactUrgence;
  private String descriptionProbleSante;
  private boolean orphelinDesDeuxParent;
  private boolean orphelinDeMere;
  private boolean orphelinDesDePere;
  @ManyToOne
  @JoinColumn(name = "tuteur_id")
  private ParentEtudiantTable tuteur;
  @ManyToOne
  @JoinColumn(name = "pere_id", nullable = false)
  private ParentEtudiantTable pere;
  @ManyToOne
  @JoinColumn(name = "mere_id", nullable = false)
  private ParentEtudiantTable mere;
  @ManyToOne
  @JoinColumn(name = "classe_id")
  private ClasseTable classe;

  public int calculerAge() {
    LocalDate maintenant = LocalDate.now();
    Period periode = Period.between(dateNaissance, maintenant);
    return periode.getYears();
  }
  public String nomComplet() {
    return this.nom + " " + this.prenoms;
  }
}
