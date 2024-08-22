package com.luna.school.typeenseignant.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-21
 */
@Getter
@Setter
public class ModifierTypeEnseignantCammande extends CreerTypeEnseignantCommande {
  @NotNull(message = "L'identifiant est requise !")
  private UUID id;

}
