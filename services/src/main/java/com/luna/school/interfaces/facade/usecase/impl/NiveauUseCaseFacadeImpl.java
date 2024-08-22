package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.interfaces.facade.usecase.NiveauCaseFacade;
import com.luna.school.niveau.application.commande.CreerNiveauCommande;
import com.luna.school.niveau.application.commande.ModifierNiveauCommande;
import com.luna.school.niveau.application.gestionnairecommande.GestionnaireCreerNiveauCommande;
import com.luna.school.niveau.application.gestionnairecommande.GestionnaireModifierNiveauCommande;
import com.luna.school.niveau.application.gestionnairecommande.GestionnaireSupprimerNiveauCommande;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
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
public class NiveauUseCaseFacadeImpl implements NiveauCaseFacade {

  private final GestionnaireCommande<CreerNiveauCommande> creerGestionnaireCommande;
  private final GestionnaireCommande<ModifierNiveauCommande> modifierTGestionnaireCommande;
  private final GestionnaireSupprimerNiveauCommande gestionnaireSupprimer;

  public NiveauUseCaseFacadeImpl(
      NiveauRepositoryPort niveauRepositoryPort, PersonnelRepositoryPort personnelRepositoryPort) {
    this.creerGestionnaireCommande = new GestionnaireCreerNiveauCommande(niveauRepositoryPort,
        personnelRepositoryPort);
    this.modifierTGestionnaireCommande = new GestionnaireModifierNiveauCommande(
        niveauRepositoryPort);
    this.gestionnaireSupprimer = new GestionnaireSupprimerNiveauCommande(niveauRepositoryPort);
  }

  @Override
  public void creer(CreerNiveauCommande commande) {
    this.creerGestionnaireCommande.execute(commande);
  }

  @Override
  public void modifier(ModifierNiveauCommande commande) {
    this.modifierTGestionnaireCommande.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.gestionnaireSupprimer.execute(id);
  }
}
