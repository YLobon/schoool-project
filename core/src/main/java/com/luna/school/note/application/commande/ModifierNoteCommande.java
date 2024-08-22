package com.luna.school.note.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-09 9:27 p.m..
 */
@Setter
@Getter
public class ModifierNoteCommande extends CreerNoteCommande{

  @NotNull(message = "l'identifiant de la note est requis !")
  private UUID id;
}
