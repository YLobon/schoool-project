package com.luna.school.anneescolaire.application.casutilisation;


import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerAnneeScolaire {

  private final AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;
  private final Logger logger = Logger.getLogger(CreerAnneeScolaire.class.getName());

  public CreerAnneeScolaire(AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.anneeScolaireRepositoryPort = anneeScolaireRepositoryPort;
  }

  public void creer(CreerAnneeScolaireCommande commande) {
    this.existeParLibelle(commande.getLibelle());
    this.verifierOdreDate(commande.getDateDebut(), commande.getDateFin());
    var anneeScolaire = new AnneeScolaire();
    anneeScolaire.setId(UUID.randomUUID());
    anneeScolaire.setLibelle(commande.getLibelle());
    anneeScolaire.setDateDebut(commande.getDateDebut());
    anneeScolaire.setDateFin(commande.getDateFin());
    this.anneeScolaireRepositoryPort.enregistrer(anneeScolaire);
    logger.info("enregistrement effectué avec succès !");
  }

  private void verifierOdreDate(LocalDate dateDebut, LocalDate dateFin) {
    if (dateDebut.isAfter(dateFin) || dateDebut.isEqual(dateFin)) {
      throw new AnneeScolaireException("Verifier ordre des dates svp !");
    }
  }

  private void existeParLibelle(String libelle) {
    boolean existeParLibelle = this.anneeScolaireRepositoryPort.existeParLibelle(libelle);
    if (existeParLibelle) {
      throw new AnneeScolaireException("ce libelle existe déjà !");
    }
  }
}