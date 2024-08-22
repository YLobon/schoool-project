package com.luna.school.enseignant.application.casutilisation;

import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class SupprimerEnseignant {
  private final EnseignantRepositoryPort enseignantRepositoryPort;

  public SupprimerEnseignant(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }


  public void supprimer(UUID enseignantId) {
    this.enseignantRepositoryPort.supprimer(enseignantId);
  }

}
