package com.luna.school.anneescolaire.application.casutilisation;


import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.util.Optional;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */

public class SupprimerAnneeScolaire {
  private final AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;
  public SupprimerAnneeScolaire(AnneeScolaireRepositoryPort anneeScolaireRepositoryPort
	) {
    this.anneeScolaireRepositoryPort = anneeScolaireRepositoryPort;
	}

  public void supprimer(UUID annnscolaireId) {
    this.verifierAnneScolaire(annnscolaireId);
    this.anneeScolaireRepositoryPort.supprimer(annnscolaireId);
  }

  private void verifierAnneScolaire(UUID controleId) {
    AnneeScolaire anneeScolaire = this.recupererParId(controleId);
      if (!anneeScolaire.anneePrecedente()) {
        String message = "Impossible d'effectuer la suppression car l'année n'est pas en cours !";
        throw new AnneeScolaireException(message);
      }


  }

  private AnneeScolaire recupererParId(UUID id){
    Optional<AnneeScolaire> anneeScolaire = this.anneeScolaireRepositoryPort.recupererParId(id);
    if (anneeScolaire.isPresent()){
      return anneeScolaire.get();
    }else {
      throw new AnneeScolaireException("L'année est introuvable !");
    }
  }
}
