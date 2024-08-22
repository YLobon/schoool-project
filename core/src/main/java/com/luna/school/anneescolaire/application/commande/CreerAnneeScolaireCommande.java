package com.luna.school.anneescolaire.application.commande;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-18
 */
@Getter
@Setter
public class CreerAnneeScolaireCommande {

  @NotBlank(message = "le libelle est requis !")
  private String libelle;
  @NotNull(message = "La date de debut est requise !")
  private LocalDate dateDebut;
  @NotNull(message = "La date de fin est requise !")
  private LocalDate dateFin;
}
