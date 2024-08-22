package com.luna.school.etudiant.application.vm;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.pays.domaine.entite.Pays;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 5:24 p.m..
 */
@Getter
@Setter
public class ParentEtudiantDetailVM {
  private UUID id;
  private Civilite civilite;
  private Pays nationnailite;
  private String nom;
  private String prenoms;
  private String fonction;
  private String residence;
  private String contact;
  private TypePiece piece;
  private String numeroPiece;
}
