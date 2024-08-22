package com.luna.school.personnel.application.gestionnairecommande;

import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.personnel.application.casutilisation.ModifierPersonnel;
import com.luna.school.personnel.application.commande.ModifierPersonnelCommande;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireModifierPersonnelCommande implements
    GestionnaireCommande<ModifierPersonnelCommande> {

  private final ModifierPersonnel modifierPersonnel;

  public GestionnaireModifierPersonnelCommande(PersonnelRepositoryPort personnelRepositoryPort,
      PaysRepositoryPort paysRepositoryPort) {
    this.modifierPersonnel = new ModifierPersonnel(personnelRepositoryPort,paysRepositoryPort);
  }

  @Override
  public void execute(ModifierPersonnelCommande commande) {
    this.modifierPersonnel.modifier(commande);
  }
}
