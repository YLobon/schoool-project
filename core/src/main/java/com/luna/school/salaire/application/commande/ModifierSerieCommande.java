package com.luna.school.salaire.application.commande;

import com.luna.school.serie.application.commande.CreerSerieCommande;
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
