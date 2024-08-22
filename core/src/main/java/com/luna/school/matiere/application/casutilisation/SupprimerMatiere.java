package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.exception.MatiereException;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 8:23 a.m..
 */
public class SupprimerMatiere {

  private final MatiereRepositoryPort matiereRepositoryPort;

  public SupprimerMatiere(MatiereRepositoryPort matiereRepositoryPort) {
    this.matiereRepositoryPort = matiereRepositoryPort;
  }

  public void supprimer(UUID idMatiere) {
    this.verifierSiMatiereSupprimable(idMatiere);
    this.matiereRepositoryPort.supprimer(idMatiere);
  }

  private void verifierSiMatiereSupprimable(UUID idMatiere) {
    Matiere matiere = this.matiereRepositoryPort.recupererParId(idMatiere);
    boolean hasSousMatiere =
        matiere.getSousMatieres() != null && !matiere.getSousMatieres().isEmpty();
    boolean hasNotes = matiere.getSousMatieres().get(0).getNote() != 0;

    if (hasSousMatiere || hasNotes) {
      throw new MatiereException(
          "La matière ne peut pas être supprimée car elle a des sous matières ou une note enregistrée.");
    }
  }
}
