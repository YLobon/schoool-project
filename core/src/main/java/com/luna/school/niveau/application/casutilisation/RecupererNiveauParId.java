package com.luna.school.niveau.application.casutilisation;

import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.application.vm.NiveauDetailsVM;
import com.luna.school.niveau.domaine.entite.Niveau;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class RecupererNiveauParId {

  private final NiveauRepositoryPort niveauRepositoryPort;

  public RecupererNiveauParId(NiveauRepositoryPort niveauRepositoryPort) {
    this.niveauRepositoryPort = niveauRepositoryPort;
  }

  public NiveauDetailsVM recupererNiveauParId(UUID id){
    Niveau niveau = this.niveauRepositoryPort.recupererParId(id);
    return new NiveauDetailsVM(niveau.getId(),niveau.getNom(),niveau.getMontantScolarite());
  }
}
