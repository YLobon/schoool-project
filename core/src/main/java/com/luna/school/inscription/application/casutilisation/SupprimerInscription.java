package com.luna.school.inscription.application.casutilisation;

import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.inscription.domaine.entite.Inscription;
import com.luna.school.inscription.domaine.exception.InscriptionException;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 8:23 a.m..
 */
public class SupprimerInscription {

  private final InscriptionRepositoryPort inscriptionRepositoryPort;

  public SupprimerInscription(InscriptionRepositoryPort inscriptionRepositoryPort) {
    this.inscriptionRepositoryPort = inscriptionRepositoryPort;
  }

  public void supprimer(UUID idInscription) {
    this.verifierSiInscriptionSupprimable(idInscription);
    this.inscriptionRepositoryPort.supprimer(idInscription);
  }

  private void verifierSiInscriptionSupprimable(UUID idInscription) {
    Inscription inscription = this.inscriptionRepositoryPort.recupereParId(idInscription);
    if (inscription.getEtudiant().getId() == null){
      throw new InscriptionException("pas d'étudiant affecté à cette inscription !");
    }

  }
}
