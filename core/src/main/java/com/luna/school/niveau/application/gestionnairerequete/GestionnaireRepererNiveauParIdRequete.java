package com.luna.school.niveau.application.gestionnairerequete;

import com.luna.school.niveau.application.casutilisation.RecupererNiveauParId;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.application.vm.NiveauDetailsVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireRepererNiveauParIdRequete implements GestionnaireRequete<NiveauDetailsVM, UUID> {
private final RecupererNiveauParId recupererNiveauParId;

  public GestionnaireRepererNiveauParIdRequete(NiveauRepositoryPort niveauRepositoryPort) {
    this.recupererNiveauParId = new RecupererNiveauParId(niveauRepositoryPort);
  }

  @Override
  public NiveauDetailsVM requete(UUID id) {
    return this.recupererNiveauParId.recupererNiveauParId(id);
  }
}
