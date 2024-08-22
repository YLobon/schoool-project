package com.luna.school.serie.application.commande;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-02
 */
@Getter
@Setter
public class CreerSerieCommande {

  @NotBlank(message = "Le libelle de la serie est requis !")
  private String libelle;

}
