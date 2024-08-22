package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.enseignant.application.casutilisation.SupprimerEnseignant;
import com.luna.school.enseignant.application.commande.CreerEnseignantCommande;
import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import com.luna.school.enseignant.application.gestionnairecommande.GestionnaireCreerEnseignantCommande;
import com.luna.school.enseignant.application.gestionnairecommande.GestionnaireModifierEnseignantCommande;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.interfaces.facade.usecase.EnseignantUseCaseFacade;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class EnseignantUseCaseFacadeImpl implements EnseignantUseCaseFacade {

  private final GestionnaireCommande<CreerEnseignantCommande> gestionnaireCreer;
  private final GestionnaireCommande<ModifierEnseignantCommande> gestionnaireModifier;
  private final SupprimerEnseignant supprimerEnseignant;

  public EnseignantUseCaseFacadeImpl(EnseignantRepositoryPort enseignantRepositoryPort,
      TypeEnseignantRepositoryPort typeEnseignantRepositoryPort, PaysRepositoryPort paysRepositoryPort) {
    gestionnaireCreer = new GestionnaireCreerEnseignantCommande(
        enseignantRepositoryPort, typeEnseignantRepositoryPort,paysRepositoryPort);
    gestionnaireModifier = new GestionnaireModifierEnseignantCommande(
        enseignantRepositoryPort, typeEnseignantRepositoryPort,paysRepositoryPort);
    this.supprimerEnseignant = new SupprimerEnseignant(
        enseignantRepositoryPort);
  }

  @Override
  public void creer(CreerEnseignantCommande commande) {
    this.gestionnaireCreer.execute(commande);
  }

  @Override
  public void modifier(ModifierEnseignantCommande commande) {
    this.gestionnaireModifier.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.supprimerEnseignant.supprimer(id);
  }
}
