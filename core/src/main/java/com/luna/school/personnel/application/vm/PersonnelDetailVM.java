package com.luna.school.personnel.application.vm;

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
 * @Author BOUA YVES 2024-05-30 11:18 p.m..
 */
@Getter
@Setter
public class PersonnelDetailVM {

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
  private String matricule;
}
