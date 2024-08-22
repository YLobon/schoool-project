package com.luna.school.examen.application.gestionnairerequete;


import com.luna.school.anneescolaire.application.casutilisation.RecupererAnneeScolaireParId;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireRecupererAnneeScolaireParId implements
    GestionnaireRequete<AnneeScolaireDatailsVM, UUID> {

  private final RecupererAnneeScolaireParId recupererAnneeScolaireParId;

  public GestionnaireRecupererAnneeScolaireParId(
      AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.recupererAnneeScolaireParId = new RecupererAnneeScolaireParId(anneeScolaireRepositoryPort);
  }

  @Override
  public AnneeScolaireDatailsVM requete(UUID id) {
    return this.recupererAnneeScolaireParId.recupererAnneeScolaireParId(id);
  }
}
