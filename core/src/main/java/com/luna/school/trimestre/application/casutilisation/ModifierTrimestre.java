package com.luna.school.trimestre.application.casutilisation;

import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import com.luna.school.trimestre.application.exception.TrimestreException;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.Optional;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ModifierTrimestre {
private final TrimestreRepositoryPort trimestreRepositoryPort;
private final AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;

  public ModifierTrimestre(TrimestreRepositoryPort trimestreRepositoryPort, AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.trimestreRepositoryPort = trimestreRepositoryPort;
    this.anneeScolaireRepositoryPort = anneeScolaireRepositoryPort;
  }

  public void modifier(ModifierTrimestreCommande commande) {
    Optional<AnneeScolaire> anneeScolaireOptional = this.anneeScolaireRepositoryPort.recupererParId(
        commande.getAnneeScolaireId());
    if (anneeScolaireOptional.isEmpty()){
      throw new TrimestreException("Impossible de trouver l'année scolaire");
    }
    Trimestre trimestre = this.trimestreRepositoryPort.recupererParId(commande.getId());
    trimestre.setLibelle(commande.getLibelle());
    trimestre.setDateDebut(commande.getDateDebut());
    trimestre.setDateFin(commande.getDateFin());
    trimestre.setAnneeScolaire(anneeScolaireOptional.get());
    this.trimestreRepositoryPort.enregistrer(trimestre);
  }
}
