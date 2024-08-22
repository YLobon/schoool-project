package com.luna.school.salaire.application.commande;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-02
 */
@Getter
@Setter
public class CreerSalaireCommande {

  @NotBlank(message = "L'identifiant du salaire est requis !")
  private UUID personnalId;

}
