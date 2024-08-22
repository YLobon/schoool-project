package com.luna.school.niveau.application.gestionnairecommande;

import com.luna.school.niveau.application.casutilisation.SupprimerNiveau;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireSupprimerNiveauCommande implements GestionnaireCommande<UUID> {
private final SupprimerNiveau supprimerNiveau;

  public GestionnaireSupprimerNiveauCommande(NiveauRepositoryPort niveauRepositoryPort) {
    this.supprimerNiveau = new SupprimerNiveau(niveauRepositoryPort);
  }

  @Override
  public void execute(UUID id) {
    this.supprimerNiveau.supprimer(id);
  }
}
