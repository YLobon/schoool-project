package com.luna.school.niveau.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
public class ModifierNiveauCommande extends CreerNiveauCommande {

  @NotNull
  private UUID id;
}
