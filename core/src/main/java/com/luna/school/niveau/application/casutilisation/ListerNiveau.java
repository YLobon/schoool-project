package com.luna.school.niveau.application.casutilisation;

import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ListerNiveau {

  private final NiveauRepositoryPort niveauRepositoryPort;

  public ListerNiveau(NiveauRepositoryPort niveauRepositoryPort) {
    this.niveauRepositoryPort = niveauRepositoryPort;
  }

  public List<NiveauEssentielVM> listerAnneeScolaire() {
    return this.niveauRepositoryPort.lister();
  }
}
