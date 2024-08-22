package com.luna.school.anneescolaire.application.casutilisation;


import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ListerAnneeScolaire {

  private final AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;

  public ListerAnneeScolaire(AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.anneeScolaireRepositoryPort = anneeScolaireRepositoryPort;
  }

  public List<AnneeScolaireEssentielVM> listerAnneeScolaire() {
    return this.anneeScolaireRepositoryPort.lister();
  }
}
