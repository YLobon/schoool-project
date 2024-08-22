package com.luna.school.permission.application.commande;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
public class CreerPermissionEleveCommande {

  @NotBlank(message = "La description est obligatoire !")
  private String description;
  @NotNull(message = "La date de debut est obligatoire !")
  private LocalDate dateDebut;
  @NotNull(message = "La date de fin est obligatoire !")
  private LocalDate dateFin;
  @NotNull(message = "L'identifiant de l'eleve est requis !")
  private UUID eleveId;

}
