package com.luna.school.pays.application.casutilisation;

import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.application.vm.PaysVM;
import com.luna.school.pays.domaine.entite.Pays;
import java.util.List;

/**
 * <p>Classe de récuperation des listes des {@link Pays}.</p>
 *
 * @author BOUA YVES 2024-05-21
 */
public class ListePays {
  private final PaysRepositoryPort paysRepositoryPort;

  public ListePays(PaysRepositoryPort paysRepositoryPort) {
    this.paysRepositoryPort = paysRepositoryPort;
  }

  /**
   * <p>Methode de récuperation de la liste des {@link Pays}.</p>
   *
   * @return la Liste des {@link Pays}
   */
  public List<PaysVM> lister() {
    return this.paysRepositoryPort.lister();
  }
}
