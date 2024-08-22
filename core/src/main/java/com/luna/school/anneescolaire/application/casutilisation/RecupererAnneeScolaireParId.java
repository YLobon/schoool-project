package com.luna.school.anneescolaire.application.casutilisation;


import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class RecupererAnneeScolaireParId {

  private final AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;

  public RecupererAnneeScolaireParId(AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.anneeScolaireRepositoryPort = anneeScolaireRepositoryPort;
  }

  public AnneeScolaireDatailsVM recupererAnneeScolaireParId(UUID id){
    AnneeScolaire anneeScolaire = this.anneeScolaireRepositoryPort.recupererParId(id).get();
    return new AnneeScolaireDatailsVM(anneeScolaire.getId(),anneeScolaire.getLibelle(),anneeScolaire.getDateDebut(),anneeScolaire.getDateFin());
  }
}
