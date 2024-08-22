package com.luna.school.examen.application.commande;

import com.luna.school.examen.domaine.objetvaleur.TypeExamen;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-29 7:16 p.m..
 */
@Getter
@Setter
public class AjouterMatiereExamenCommande {

  @NotNull(message = "L'identifiant de la matierère est requis !")
  private UUID matiereId;
  @NotNull(message = "L'identifiant de l'examen est requis !")
  private UUID examenId;
  @NotNull(message = "Le coefficient de la matierère est requis !")
  private double coeficient;
  @NotNull
  private TypeExamen typeExamen;

}
