package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.comptabilite.application.port.ScolariteRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.ParentEtudiantRepositoryPort;
import com.luna.school.inscription.application.casutilisation.SupprimerInscription;
import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.inscription.application.commande.ModifierInscriptionCommande;
import com.luna.school.inscription.application.gestionnairecommande.GestionnaireCreerInscriptionCommande;
import com.luna.school.inscription.application.gestionnairecommande.GestionnaireModifierInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.interfaces.facade.usecase.InscriptionUseCaseFacade;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
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
public class InscriptionUseCaseFacadeImpl implements InscriptionUseCaseFacade {

  private final GestionnaireCommande<CreerInscriptionCommande>
      creerInsciptionCommandeGestionnaireCommande;
  private final GestionnaireCommande<ModifierInscriptionCommande>
      modifierClasseCommandeGestionnaireCommande;
  private final SupprimerInscription supprimerInscription;

  public InscriptionUseCaseFacadeImpl(InscriptionRepositoryPort inscriptionRepositoryPort,
      ParentEtudiantRepositoryPort parentEtudiantRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort, ClasseRepositoryPort classeRepositoryPort,
      ScolariteRepositoryPort scolariteRepositoryPort, MatiereRepositoryPort matiereRepositoryPort) {
    this.creerInsciptionCommandeGestionnaireCommande =
        new GestionnaireCreerInscriptionCommande(inscriptionRepositoryPort,
            parentEtudiantRepositoryPort, etudiantRepositoryPort,
            classeRepositoryPort,scolariteRepositoryPort,matiereRepositoryPort);
    this.modifierClasseCommandeGestionnaireCommande =
        new GestionnaireModifierInscriptionCommande(inscriptionRepositoryPort,
            parentEtudiantRepositoryPort, etudiantRepositoryPort, classeRepositoryPort);
    supprimerInscription = new SupprimerInscription(inscriptionRepositoryPort);
  }


  @Override
  public void creer(CreerInscriptionCommande commande) {
    this.creerInsciptionCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void modifier(ModifierInscriptionCommande commande) {
    this.modifierClasseCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.supprimerInscription.supprimer(id);
  }
}
