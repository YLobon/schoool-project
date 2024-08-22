package com.luna.school.examen.application.gestionnairecommande;



import com.luna.school.anneescolaire.application.casutilisation.SupprimerAnneeScolaire;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class GestionnaireSupprimerAnneeScolaire implements GestionnaireCommande<UUID> {

  private final SupprimerAnneeScolaire supprimerAnneeScolaire;

  public GestionnaireSupprimerAnneeScolaire(
      AnneeScolaireRepositoryPort anneeScolaireRepositoryPort
  ) {
    this.supprimerAnneeScolaire = new SupprimerAnneeScolaire(anneeScolaireRepositoryPort);
  }

  @Override
  public void execute(UUID anneeScolaireId) {
    this.supprimerAnneeScolaire.supprimer(anneeScolaireId);
  }
}
