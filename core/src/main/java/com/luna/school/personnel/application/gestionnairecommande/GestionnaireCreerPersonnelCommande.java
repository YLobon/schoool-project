package com.luna.school.personnel.application.gestionnairecommande;

import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.personnel.application.casutilisation.CreerPersonnel;
import com.luna.school.personnel.application.commande.CreerPersonnelCommande;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireCreerPersonnelCommande implements
    GestionnaireCommande<CreerPersonnelCommande> {

  private final CreerPersonnel creerPersonnel;

  public GestionnaireCreerPersonnelCommande(PersonnelRepositoryPort personnelRepositoryPort,
      PaysRepositoryPort paysRepositoryPort) {
    this.creerPersonnel = new CreerPersonnel(personnelRepositoryPort,paysRepositoryPort);
  }

  @Override
  public void execute(CreerPersonnelCommande commande) {
    this.creerPersonnel.creer(commande);
  }
}
