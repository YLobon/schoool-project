package com.luna.school.entite;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @author BOUA YVES 2024-06-01 11:44 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "parent-tuteur-etudiant")
public class ParentTuteurEtudiantTable {

  @Id
  private UUID id;
  @Enumerated(EnumType.STRING)
  private Civilite civilite;
  @ManyToOne
  @JoinColumn(name = "nationnailite_id")
  private PaysTable nationnailite;
  private String nom;
  private String prenoms;
  private String fonction;
  private String residence;
  private String contact;
  @Enumerated(EnumType.STRING)
  private TypePiece piece;
  private String numeroPiece;
}
