package com.luna.school.pays.application.casutilisation;

import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.tools.NonTrouveException;

/**
 * <p>Classe de récupertion des {@link Pays} par libelle.</p>
 *
 * @author BOUA YVES
 */
public class RecupererParLibellePays {
  private final PaysRepositoryPort paysRepositoryPort;


  public RecupererParLibellePays(PaysRepositoryPort paysRepositoryPort) {
    this.paysRepositoryPort = paysRepositoryPort;
  }

  /**
   * <p>Méthode de recupereration des {@link Pays} par libelle.</p>
   *
   * @param libelle libelle d'un pays
   * @return {@link Pays}
   */
  public Pays recupererParNomPays(String libelle) {
    return this.paysRepositoryPort.recupererParNom(libelle).orElseThrow(
        ()-> new NonTrouveException("Aucun pays trouver pour cet "+libelle)
    );
  }
}
