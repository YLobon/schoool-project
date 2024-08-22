package com.luna.school.note.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-09 9:04 p.m..
 */
@Getter
@Setter
public class CreerNoteCommande {

  @NotNull(message = "La note est requise !")
  private double note;
  @NotNull(message = "Le bareme est requise !")
  private double bareme;
  @NotNull(message = "L'identifiant de l'etudiant est requis !")
  private UUID etudiantId;
  @NotNull(message = "L'identifiant de la classe est requis !")
  private UUID classeId;
  @NotNull(message = "Le trimestre est requis !")
  private UUID trimestreId;
  @NotNull(message = "L'enseignant est requis !")
  private UUID enseignantId;
  @NotNull(message = "La matière est requise !")
  private UUID matiereId;
}
