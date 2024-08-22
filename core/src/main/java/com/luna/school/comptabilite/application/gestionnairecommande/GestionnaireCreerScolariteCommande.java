package com.luna.school.comptabilite.application.gestionnairecommande;

import com.luna.school.comptabilite.application.casutilisation.PayerScolarite;
import com.luna.school.comptabilite.application.commande.PayerScolariteCommande;
import com.luna.school.comptabilite.application.port.ScolariteRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireCreerScolariteCommande implements
    GestionnaireCommande<PayerScolariteCommande> {

  private final PayerScolarite payerScolarite;

  public GestionnaireCreerScolariteCommande(ScolariteRepositoryPort scolariteRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort,
      InscriptionRepositoryPort inscriptionRepositoryPort) {
    this.payerScolarite = new PayerScolarite(scolariteRepositoryPort, etudiantRepositoryPort,
        inscriptionRepositoryPort);
  }

  @Override
  public void execute(PayerScolariteCommande commande) {
    this.payerScolarite.payerScolarite(commande);
  }
}
