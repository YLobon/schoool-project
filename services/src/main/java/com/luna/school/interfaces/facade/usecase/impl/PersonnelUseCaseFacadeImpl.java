package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.interfaces.facade.usecase.PersonnelUseCaseFacade;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.personnel.application.commande.CreerPersonnelCommande;
import com.luna.school.personnel.application.commande.ModifierPersonnelCommande;
import com.luna.school.personnel.application.gestionnairecommande.GestionnaireCreerPersonnelCommande;
import com.luna.school.personnel.application.gestionnairecommande.GestionnaireModifierPersonnelCommande;
import com.luna.school.personnel.application.gestionnairecommande.GestionnaireSupprimerPersonnelCommande;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:18 a.m..
 */
@Service
public class PersonnelUseCaseFacadeImpl implements PersonnelUseCaseFacade {

  private final GestionnaireCommande<CreerPersonnelCommande>
      creerCommandeGestionnaireCommande;
  private final GestionnaireCommande<ModifierPersonnelCommande>
      modifierCommandeGestionnaireCommande;
  private final GestionnaireSupprimerPersonnelCommande gestionnaireSupprimer;

  public PersonnelUseCaseFacadeImpl(PersonnelRepositoryPort personnelRepositoryPort,
      PaysRepositoryPort paysRepositoryPort) {
    this.creerCommandeGestionnaireCommande =
        new GestionnaireCreerPersonnelCommande(personnelRepositoryPort,paysRepositoryPort);
    this.modifierCommandeGestionnaireCommande =
        new GestionnaireModifierPersonnelCommande(personnelRepositoryPort,paysRepositoryPort);
    this.gestionnaireSupprimer =
        new GestionnaireSupprimerPersonnelCommande(personnelRepositoryPort);
  }

  @Override
  public void creer(CreerPersonnelCommande commande) {
    this.creerCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void modifier(ModifierPersonnelCommande commande) {
    this.modifierCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.gestionnaireSupprimer.execute(id);
  }
}
