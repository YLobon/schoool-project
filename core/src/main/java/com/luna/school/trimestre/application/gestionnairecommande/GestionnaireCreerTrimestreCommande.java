package com.luna.school.trimestre.application.gestionnairecommande;

import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.casutilisation.CreerTrimestre;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireCreerTrimestreCommande implements
    GestionnaireCommande<CreerTrimestreCommande> {

  private final CreerTrimestre CreeTrimestre;

  public GestionnaireCreerTrimestreCommande(TrimestreRepositoryPort trimestreRepositoryPort,
      AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    CreeTrimestre = new CreerTrimestre(trimestreRepositoryPort, anneeScolaireRepositoryPort);
  }

  @Override
  public void execute(CreerTrimestreCommande commande) {
    this.CreeTrimestre.CreerTrimestre(commande);
  }
}
