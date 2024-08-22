package com.luna.school.matiere.application.commande;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-02
 */
@Getter
@Setter
public class CreerMatiereCommande {

  @NotBlank(message = "Le nom est requis !")
  private String nom;
  @NotNull(message = "Le coefficient est requis !")
  private double coefficient;
  @NotNull(message = "La sous matiere est requis !")
  private boolean sousMatierePresent;
}
