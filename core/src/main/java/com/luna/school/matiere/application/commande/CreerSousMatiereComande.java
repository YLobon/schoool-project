package com.luna.school.matiere.application.commande;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-10
 */
@Setter
@Getter
public class CreerSousMatiereComande {

  @NotBlank(message = "Le nom de sous matiere est requis !")
  private String nomSousMatiere;
  @NotNull(message = "Le coefficient de sous matiere est requis !")
  private double coefficient;
  @NotNull(message = "La note de sous matiere est requis !")
  private double note;
}
