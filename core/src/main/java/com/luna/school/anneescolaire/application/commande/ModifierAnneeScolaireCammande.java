package com.luna.school.anneescolaire.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-21
 */
@Getter
@Setter
public class ModifierAnneeScolaireCammande extends CreerAnneeScolaireCommande{
  @NotNull(message = "L'identifiant est requise !")
  private UUID id;

}
