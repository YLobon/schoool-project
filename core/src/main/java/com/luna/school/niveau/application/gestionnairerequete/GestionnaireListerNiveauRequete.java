package com.luna.school.niveau.application.gestionnairerequete;

import com.luna.school.niveau.application.casutilisation.ListerNiveau;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireListerNiveauRequete implements GestionnaireRequete<List<NiveauEssentielVM>,Void> {
private final ListerNiveau listerNiveau;

  public GestionnaireListerNiveauRequete(NiveauRepositoryPort niveauRepositoryPort) {
    this.listerNiveau = new ListerNiveau(niveauRepositoryPort);
  }

  @Override
  public List<NiveauEssentielVM> requete(Void var1) {
    return this.listerNiveau.listerAnneeScolaire();

  }
}
