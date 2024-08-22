package com.luna.school.trimestre.application.commande;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-21
 */

@Getter
@Setter
public class CreerTrimestreCommande {

  @NotBlank(message = "Le libelle du trimestre est obligatoire !")
  private String libelle;
  @NotNull(message = "La date de debut du trimestre est obligatoire !")
  private LocalDate dateDebut;
  @NotNull(message = "La date de fin du trimestre est obligatoire !")
  private LocalDate dateFin;
  @NotNull(message = "L'identifiant de l'anne est obligatoire !")
  private UUID anneeScolaireId;
}
