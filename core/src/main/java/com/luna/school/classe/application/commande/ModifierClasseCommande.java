
package com.luna.school.classe.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Setter
@Getter
public class ModifierClasseCommande extends CreerClasseCommande {

  @NotNull(message = "L'identifiant de la classe est requis !")
  private UUID classeId;
}
