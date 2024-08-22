package com.luna.school.pays.application.gestionnairerequete;

import com.luna.school.pays.application.casutilisation.ListePays;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.application.vm.PaysVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;

/**
 * <p>Gestionnaire de requête liste des {@link Pays}.</p>
 *
 * @author BOUA YVES
 */
public class GestionnaireListerPays implements GestionnaireRequete<List<PaysVM>, Void> {

  private final ListePays listePays;

  public GestionnaireListerPays(
      PaysRepositoryPort paysRepositoryPort
  ) {
    this.listePays = new ListePays(paysRepositoryPort);
  }

  @Override
  public List<PaysVM> requete(Void unused) {
    return this.listePays.lister();
  }
}
