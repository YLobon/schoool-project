package com.luna.school.personnel.domaine.entite;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.personnel.domaine.objetvaleur.TypePersonnel;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-23
 */
@Getter
@Setter
public class Personnel {
  private UUID id;
  private Civilite civilite;
  private TypePersonnel typePersonnel;
  private Pays nationnailite;
  private String nom;
  private String prenoms;
  private String fonction;
  private String residence;
  private double salaire;
  private String contact;
  private TypePiece piece;
  private String numeroPiece;
  private String matricule;
}
