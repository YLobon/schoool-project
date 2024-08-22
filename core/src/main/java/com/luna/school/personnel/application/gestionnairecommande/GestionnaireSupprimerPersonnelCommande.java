package com.luna.school.personnel.application.gestionnairecommande;

import com.luna.school.personnel.application.casutilisation.SupprimerPersonnel;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireSupprimerPersonnelCommande implements GestionnaireCommande<UUID> {

  private final SupprimerPersonnel supprimerPersonnel;

  public GestionnaireSupprimerPersonnelCommande(PersonnelRepositoryPort personnelRepositoryPort) {
    this.supprimerPersonnel = new SupprimerPersonnel(personnelRepositoryPort);
  }

  @Override
  public void execute(UUID id) {
    this.supprimerPersonnel.supprimer(id);
  }
}
