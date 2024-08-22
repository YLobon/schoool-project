package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.comptabilite.application.commande.PayerScolariteCommande;
import com.luna.school.comptabilite.application.gestionnairecommande.GestionnaireCreerScolariteCommande;
import com.luna.school.comptabilite.application.port.ScolariteRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.interfaces.facade.usecase.ScolariteUseCaseFacade;
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
public class ScolariteUseCaseFacadeImpl implements ScolariteUseCaseFacade {

  private final GestionnaireCommande<PayerScolariteCommande> payerScolariteCommandeGestionnaireCommande;

  public ScolariteUseCaseFacadeImpl(ScolariteRepositoryPort scolariteRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort,
      InscriptionRepositoryPort inscriptionRepositoryPort) {
    this.payerScolariteCommandeGestionnaireCommande = new GestionnaireCreerScolariteCommande(
        scolariteRepositoryPort, etudiantRepositoryPort, inscriptionRepositoryPort);
  }

  @Override
  public void payer(PayerScolariteCommande commande) {
    this.payerScolariteCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {

  }

}
