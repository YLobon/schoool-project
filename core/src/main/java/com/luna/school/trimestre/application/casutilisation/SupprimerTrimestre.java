package com.luna.school.trimestre.application.casutilisation;

import com.luna.school.trimestre.application.exception.TrimestreException;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class SupprimerTrimestre {
  private final TrimestreRepositoryPort trimestreRepositoryPort;
  public SupprimerTrimestre(TrimestreRepositoryPort trimestreRepositoryPort
	) {
    this.trimestreRepositoryPort = trimestreRepositoryPort;
	}

  public void supprimer(UUID annnscolaireID) {
    this.verifierTrimestre(annnscolaireID);
    this.trimestreRepositoryPort.supprimer(annnscolaireID);
  }

  private void verifierTrimestre(UUID trimestreId) {
    Trimestre trimestre = this.trimestreRepositoryPort.recupererParId(trimestreId);
    if (trimestre.demarer()) {
        String message = "Impossible d'effectuer la suppression car l'anne n'est pas en cours !";
        throw new TrimestreException(message);
    }
  }
}
