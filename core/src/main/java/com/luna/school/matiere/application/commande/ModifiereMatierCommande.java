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
public class ModifiereMatierCommande extends CreerMatiereCommande {
  @NotNull(message ="L'identifiant est recquis !")
  private UUID id;
}
