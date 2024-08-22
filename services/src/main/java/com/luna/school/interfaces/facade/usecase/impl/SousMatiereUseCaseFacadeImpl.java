package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.interfaces.facade.usecase.SousMatiereUseCaseFacade;
import com.luna.school.matiere.application.casutilisation.SupprimerSousMatiere;
import com.luna.school.matiere.application.commande.CreerSousMatiereComande;
import com.luna.school.matiere.application.commande.ModifierSousMatierCommande;
import com.luna.school.matiere.application.gestionnairecommande.GestionnaireCreerSousMatiereCommande;
import com.luna.school.matiere.application.gestionnairecommande.ModifierSousMatiereGestionnaireCommande;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class SousMatiereUseCaseFacadeImpl implements SousMatiereUseCaseFacade {

  private final GestionnaireCommande<CreerSousMatiereComande> gestionnaireCreerMatiere;
  private final GestionnaireCommande<ModifierSousMatierCommande> gestionnaireModifierMatiere;
  private final SupprimerSousMatiere supprimerMatiere;

  public SousMatiereUseCaseFacadeImpl(SousMatiereRepositoryPort sousMatiereRepositoryPort) {
    gestionnaireCreerMatiere = new GestionnaireCreerSousMatiereCommande(sousMatiereRepositoryPort);
    gestionnaireModifierMatiere = new ModifierSousMatiereGestionnaireCommande(
        sousMatiereRepositoryPort);
    this.supprimerMatiere = new SupprimerSousMatiere(
        sousMatiereRepositoryPort);
  }

  @Override
  public void creer(CreerSousMatiereComande commande) {
    this.gestionnaireCreerMatiere.execute(commande);
  }

  @Override
  public void modifier(ModifierSousMatierCommande commande) {
    this.gestionnaireModifierMatiere.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.supprimerMatiere.supprimer(id);
  }
}
