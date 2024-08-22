package com.luna.school.personnel.application.commande;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-23
 */
@Getter
@Setter
public class CreerPersonnelCommande {
  @NotNull(message = "Le non est requis !")
  private Civilite civilite;
  @NotBlank(message = "Le non est requis !")
  private String nom;
  @NotBlank(message = "Le prenoms est requis !")
  private String prenoms;
  @NotBlank(message = "La fonction est requis !")
  private String fonction;
  @NotBlank(message = "Le residence est requis !")
  private String residence;
  @NotBlank(message = "Le contact est requis !")
  private String contact;
  @NotNull(message = "Le type de piece est requis !")
  private TypePiece piece;
  @NotNull(message = "Le type de piece est requis !")
  private UUID nationnailite;
  @NotBlank(message = "Le numero piece est requis !")
  private String numeroPiece;
  private String matricule;

}
