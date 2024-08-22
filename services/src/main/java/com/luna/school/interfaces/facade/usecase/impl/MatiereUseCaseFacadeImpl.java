package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.interfaces.facade.usecase.MatiereUseCaseFacade;
import com.luna.school.matiere.application.casutilisation.SupprimerMatiere;
import com.luna.school.matiere.application.commande.AssocierSousMatiereAuMatiereCommande;
import com.luna.school.matiere.application.commande.CreerMatiereCommande;
import com.luna.school.matiere.application.commande.ModifiereMatierCommande;
import com.luna.school.matiere.application.gestionnairecommande.GestionnaireAjouterSousMatiereAuMatiereCommande;
import com.luna.school.matiere.application.gestionnairecommande.GestionnaireCreerMatierCommande;
import com.luna.school.matiere.application.gestionnairecommande.ModifierMatiereGestionnaireCommande;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class MatiereUseCaseFacadeImpl implements MatiereUseCaseFacade {

  private final GestionnaireCommande<CreerMatiereCommande> gestionnaireCreerMatiere;
  private final GestionnaireCommande<ModifiereMatierCommande> gestionnaireModifierMatiere;
  private final GestionnaireCommande<AssocierSousMatiereAuMatiereCommande> ajoutDesSousMatiere;
  private final SupprimerMatiere supprimerMatiere;

  public MatiereUseCaseFacadeImpl(MatiereRepositoryPort matiereRepositoryPort,
      SousMatiereRepositoryPort sousMatiereRepositoryPort) {
    gestionnaireCreerMatiere = new GestionnaireCreerMatierCommande(matiereRepositoryPort);
    gestionnaireModifierMatiere = new ModifierMatiereGestionnaireCommande(matiereRepositoryPort);
    this.ajoutDesSousMatiere = new GestionnaireAjouterSousMatiereAuMatiereCommande(
        sousMatiereRepositoryPort, matiereRepositoryPort);
    this.supprimerMatiere = new SupprimerMatiere(
        matiereRepositoryPort);
  }


  @Override
  public void creer(CreerMatiereCommande commande) {
    this.gestionnaireCreerMatiere.execute(commande);
  }

  @Override
  public void modifier(ModifiereMatierCommande commande) {
    this.gestionnaireModifierMatiere.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.supprimerMatiere.supprimer(id);
  }

  @Override
  public void ajouterSousMatiereAuxMatiere(AssocierSousMatiereAuMatiereCommande commande) {
    this.ajoutDesSousMatiere.execute(commande);
  }
}
