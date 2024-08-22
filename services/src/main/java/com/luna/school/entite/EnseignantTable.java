package com.luna.school.entite;


import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 5:42 p.m..
 */
@Getter
@Setter
@Entity
@Table(name = "enseignant")
public class EnseignantTable {

  @Id
  private UUID id;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Civilite civilite;
  @ManyToOne
  @JoinColumn(name = "nationnailite_id", nullable = false)
  private PaysTable nationnailite;
  @Column(nullable = false)
  private String nom;
  @Column(nullable = false)
  private String prenoms;
  @Column(nullable = false)
  private String specialite;
  @Column(nullable = false)
  private String residence;
  @Column(nullable = false)
  private String contact;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TypePiece piece;
  @Column(nullable = false)
  private String numeroPiece;
  private String matricule;
  private String numeroEnseignant;
  @ManyToOne
  @JoinColumn(name = "typeEnseignant_id", nullable = false)
  private TypeEnseignantTable typeEnseignant;


  public String nomComplet() {
    return this.nom + " " + this.prenoms;
  }
}
