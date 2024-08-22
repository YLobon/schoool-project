package com.luna.school.interfaces.facade.usecase;

import com.luna.school.note.application.commande.CreerNoteCommande;
import com.luna.school.note.application.commande.ModifierNoteCommande;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:16 a.m..
 */
public interface NoteUseCaseFacade {

  void creer(CreerNoteCommande commande);
  void supprimer(UUID id);
  void modifier(ModifierNoteCommande commande);
}
