package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.interfaces.facade.usecase.TrimestreUseCaseFacade;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import com.luna.school.trimestre.application.gestionnairecommande.GestionnaireCreerTrimestreCommande;
import com.luna.school.trimestre.application.gestionnairecommande.GestionnaireModifierTrimestreCommande;
import com.luna.school.trimestre.application.gestionnairecommande.GestionnaireSupprimerTrimestre;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:18 a.m..
 */
@Service
public class TrimestreUseCaseFacadeImpl implements TrimestreUseCaseFacade {

  private final GestionnaireCommande<CreerTrimestreCommande> creerTrimestreCommandeGestionnaireCommande;
  private final GestionnaireCommande<ModifierTrimestreCommande> modifierTrimestreCommandeGestionnaireCommande;
  private final GestionnaireSupprimerTrimestre gestionnaireSupprimerTrimestre;

  public TrimestreUseCaseFacadeImpl(TrimestreRepositoryPort trimestreRepositoryPort,
      AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.creerTrimestreCommandeGestionnaireCommande = new GestionnaireCreerTrimestreCommande(trimestreRepositoryPort,anneeScolaireRepositoryPort);
    this.modifierTrimestreCommandeGestionnaireCommande = new GestionnaireModifierTrimestreCommande(trimestreRepositoryPort,anneeScolaireRepositoryPort);
    this.gestionnaireSupprimerTrimestre = new GestionnaireSupprimerTrimestre(trimestreRepositoryPort);
  }

  @Override
  public void creer(CreerTrimestreCommande commande) {
    this.creerTrimestreCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void modifier(ModifierTrimestreCommande commande) {
    this.modifierTrimestreCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.gestionnaireSupprimerTrimestre.execute(id);
  }
}
