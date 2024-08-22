package com.luna.school.enseignant.domaine.entite;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.typeenseignant.domaine.entite.TypeEnseignant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-23
 */
@Getter
@Setter
public class Enseignant {

  private UUID id;
  private Civilite civilite;
  private Pays nationnailite;
  private String nom;
  private String prenoms;
  private String residence;
  private String contact;
  private TypePiece piece;
  private String numeroPiece;
  private String matricule;
  private String specialite;
  private String numeroEnseignant;
  private TypeEnseignant typeEnseignant;
  public String nomComplet(){
    return this.nom  + " "+ this.prenoms;
  }

}
