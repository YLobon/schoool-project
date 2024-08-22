package com.luna.school.matiere.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class AssocierSousMatiereAuMatiereCommande {
  @NotNull(message = "L'identifiant de la sous matiere est requis !")
  private UUID sousMatiereId;
  @NotNull(message = "L'identifiant de la matiere est requis !")
  private UUID matiereId;

}
