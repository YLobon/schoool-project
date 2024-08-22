package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.interfaces.facade.usecase.TypeEnseignantUseCaseFacade;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.typeenseignant.application.casutilisation.SupprimerTypeEnseignant;
import com.luna.school.typeenseignant.application.commande.CreerTypeEnseignantCommande;
import com.luna.school.typeenseignant.application.commande.ModifierTypeEnseignantCammande;
import com.luna.school.typeenseignant.application.gestionnairecommande.CreerTypeEnseignantGestionnairecommande;
import com.luna.school.typeenseignant.application.gestionnairecommande.ModifierTypeEnseignantGestionnairecommande;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class TypeEnseignantUseCaseFacadeImpl implements TypeEnseignantUseCaseFacade {

  private final GestionnaireCommande<CreerTypeEnseignantCommande> gestionnaireCreer;
  private final GestionnaireCommande<ModifierTypeEnseignantCammande> gestionnaireModifier;
  private final SupprimerTypeEnseignant supprimerTypeEnseignant;

  public TypeEnseignantUseCaseFacadeImpl(
      TypeEnseignantRepositoryPort typeEnseignantRepositoryPort) {
    gestionnaireCreer = new CreerTypeEnseignantGestionnairecommande(
        typeEnseignantRepositoryPort);
    gestionnaireModifier = new ModifierTypeEnseignantGestionnairecommande(
        typeEnseignantRepositoryPort);
    this.supprimerTypeEnseignant = new SupprimerTypeEnseignant(
        typeEnseignantRepositoryPort);
  }

  @Override
  public void creer(CreerTypeEnseignantCommande commande) {
    this.gestionnaireCreer.execute(commande);
  }

  @Override
  public void modifier(ModifierTypeEnseignantCammande commande) {
    this.gestionnaireModifier.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.supprimerTypeEnseignant.supprimer(id);
  }
}


