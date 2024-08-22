package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.exception.MatiereException;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.SousMatiere;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 8:23 a.m..
 */
public class SupprimerSousMatiere {

  private final SousMatiereRepositoryPort sousMatiereRepositoryPort;

  public SupprimerSousMatiere(SousMatiereRepositoryPort sousMatiereRepositoryPort) {
    this.sousMatiereRepositoryPort = sousMatiereRepositoryPort;
  }


  public void supprimer(UUID idSousMatiere) {
    this.verifierSiMatiereSupprimable(idSousMatiere);
    this.sousMatiereRepositoryPort.supprimer(idSousMatiere);
  }

  private void verifierSiMatiereSupprimable(UUID idMatiere) {
    SousMatiere sousMatiere = this.sousMatiereRepositoryPort.recupererParId(idMatiere);
    boolean hasSousMatiere =
        sousMatiere != null && sousMatiere.getId() != null;
    boolean hasNotes = sousMatiere.getNote() != 0;

    if (hasSousMatiere || hasNotes) {
      throw new MatiereException(
          "La matière ne peut pas être supprimée car elle a des sous matières ou une note enregistrée.");
    }
  }
}
