package com.luna.school.classe.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
public class AjouterMatierClasseCommande {

  @NotNull(message = "L'identifiant de la classe est requis !")
  private UUID classeId;
  @NotNull(message = "L'identifiant de la matiere est requis !")
  private UUID matiereId;
}
