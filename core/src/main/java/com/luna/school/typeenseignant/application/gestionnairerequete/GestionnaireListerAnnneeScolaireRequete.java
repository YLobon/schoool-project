package com.luna.school.typeenseignant.application.gestionnairerequete;


import com.luna.school.anneescolaire.application.casutilisation.ListerAnneeScolaire;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireListerAnnneeScolaireRequete  implements
    GestionnaireRequete<List<AnneeScolaireEssentielVM>, Void> {

  private final ListerAnneeScolaire listerAnneeScolaire;

  public GestionnaireListerAnnneeScolaireRequete(
      AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.listerAnneeScolaire = new ListerAnneeScolaire(anneeScolaireRepositoryPort);
  }


  @Override
  public List<AnneeScolaireEssentielVM> requete(Void unused) {
    return this.listerAnneeScolaire.listerAnneeScolaire();
  }
}
