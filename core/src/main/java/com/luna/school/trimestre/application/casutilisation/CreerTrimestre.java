package com.luna.school.trimestre.application.casutilisation;

import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.exception.TrimestreException;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.Optional;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class CreerTrimestre {
  private final TrimestreRepositoryPort trimestreRepositoryPort;
  private final AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;

  public CreerTrimestre(TrimestreRepositoryPort trimestreRepositoryPort, AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.trimestreRepositoryPort = trimestreRepositoryPort;
    this.anneeScolaireRepositoryPort = anneeScolaireRepositoryPort;
  }

  public void CreerTrimestre(CreerTrimestreCommande commande) {
    this.verifierLibelleTrimestre(commande.getLibelle());
    Optional<AnneeScolaire> anneeScolaire = this.anneeScolaireRepositoryPort.recupererParId(
        commande.getAnneeScolaireId());
    if (anneeScolaire.isEmpty()){
      throw new TrimestreException("Impossible de trouver l'année choisi");
    }
    var trimestre = new Trimestre();
    trimestre.setId(UUID.randomUUID());
    trimestre.setLibelle(commande.getLibelle());
    trimestre.setDateDebut(commande.getDateDebut());
    trimestre.setDateFin(commande.getDateFin());
    trimestre.setAnneeScolaire(anneeScolaire.get());
    this.trimestreRepositoryPort.enregistrer(trimestre);
  }

  private void verifierLibelleTrimestre(String libelle) {
    boolean existeParLibelle = this.trimestreRepositoryPort.libellExiste(libelle);
    if (existeParLibelle) {
      throw new TrimestreException("Ce libelle existe déjà pour un trimestre !");
    }
  }
}
