package com.luna.school.enseignant.application.gestionnairecommande;


import com.luna.school.enseignant.application.casutilisation.SupprimerEnseignant;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class GestionnaireSupprimerEnseignant implements GestionnaireCommande<UUID> {

  private final SupprimerEnseignant supprimerEnseignant;

  public GestionnaireSupprimerEnseignant(
      EnseignantRepositoryPort enseignantRepositoryPort
  ) {
    this.supprimerEnseignant = new SupprimerEnseignant(enseignantRepositoryPort);
  }

  @Override
  public void execute(UUID enseignatrId) {
    this.supprimerEnseignant.supprimer(enseignatrId);
  }
}
