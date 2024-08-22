package com.luna.school.typeenseignant.application.casutilisation;


import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */

public class SupprimerTypeEnseignant {

  private final TypeEnseignantRepositoryPort typeEnseignantRepositoryPort;

  public SupprimerTypeEnseignant(TypeEnseignantRepositoryPort typeEnseignantRepositoryPort) {
    this.typeEnseignantRepositoryPort = typeEnseignantRepositoryPort;
  }

  public void supprimer(UUID typeEnseignantId) {
    this.typeEnseignantRepositoryPort.supprimer(typeEnseignantId);
  }
}
