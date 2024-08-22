package com.luna.school.serie.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-02
 */
@Getter
@Setter
public class ModifierSerieCommande extends CreerSerieCommande {
  @NotNull(message = "L'identifiant est requis !")
private UUID id;
}
