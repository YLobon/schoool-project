package com.luna.school.inscription.application.gestionnairecommande;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.comptabilite.application.port.ScolariteRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.ParentEtudiantRepositoryPort;
import com.luna.school.inscription.application.casutilisation.CreerInscription;
import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 5:18 a.m..
 */
public class GestionnaireCreerInscriptionCommande implements
    GestionnaireCommande<CreerInscriptionCommande> {

  private final CreerInscription creerInscription;

  public GestionnaireCreerInscriptionCommande(InscriptionRepositoryPort inscriptionRepositoryPort,
      ParentEtudiantRepositoryPort parentEtudiantRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort, ScolariteRepositoryPort scolariteRepositoryPort,
      MatiereRepositoryPort matiereRepositoryPort) {
    creerInscription = new CreerInscription(inscriptionRepositoryPort, parentEtudiantRepositoryPort,
         etudiantRepositoryPort, classeRepositoryPort,scolariteRepositoryPort,matiereRepositoryPort);
  }

  @Override
  public void execute(CreerInscriptionCommande commande) {
    this.creerInscription.creer(commande);
  }
}
