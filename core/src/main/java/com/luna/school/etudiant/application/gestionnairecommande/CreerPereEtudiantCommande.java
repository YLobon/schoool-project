package com.luna.school.etudiant.application.gestionnairecommande;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.pays.domaine.entite.Pays;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class CreerPereEtudiantCommande {
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
