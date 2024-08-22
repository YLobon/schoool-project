package com.luna.school.enseignant.application.vm;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.pays.domaine.entite.Pays;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-01
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantDetailsVM {
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
  private String numeroEnseignant;
}
