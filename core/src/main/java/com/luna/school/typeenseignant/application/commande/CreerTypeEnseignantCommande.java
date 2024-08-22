package com.luna.school.typeenseignant.application.commande;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-18
 */
@Getter
@Setter
public class CreerTypeEnseignantCommande {

  @NotBlank(message = "le libelle est requis !")
  private String libelle;
  @NotNull(message = "Le salaire par heure est requis !")
  private double SalaireParHeure;
  @NotNull(message = "La taxe pour impôt est requise !")
  private double taxe;
}
