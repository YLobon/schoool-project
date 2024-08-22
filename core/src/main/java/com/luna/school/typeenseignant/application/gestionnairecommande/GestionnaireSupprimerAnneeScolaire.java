package com.luna.school.typeenseignant.application.gestionnairecommande;


import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.typeenseignant.application.casutilisation.SupprimerTypeEnseignant;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class GestionnaireSupprimerAnneeScolaire implements GestionnaireCommande<UUID> {

  private final SupprimerTypeEnseignant supprimerTypeEnseignant;

  public GestionnaireSupprimerAnneeScolaire(
      TypeEnseignantRepositoryPort typeEnseignantRepositoryPort
  ) {
    this.supprimerTypeEnseignant = new SupprimerTypeEnseignant(typeEnseignantRepositoryPort);
  }

  @Override
  public void execute(UUID typeEnseignantId) {
    this.supprimerTypeEnseignant.supprimer(typeEnseignantId);
  }
}
