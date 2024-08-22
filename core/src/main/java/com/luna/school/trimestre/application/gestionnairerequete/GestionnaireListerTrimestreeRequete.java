package com.luna.school.trimestre.application.gestionnairerequete;


import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.trimestre.application.casutilisation.ListerTrimestre;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireListerTrimestreeRequete implements
    GestionnaireRequete<List<TrimestreEssentielVM>, Void> {

  private final ListerTrimestre listerTrimestre;

  public GestionnaireListerTrimestreeRequete(
      TrimestreRepositoryPort trimestreRepositoryPort) {
    this.listerTrimestre = new ListerTrimestre(trimestreRepositoryPort);
  }


  @Override
  public List<TrimestreEssentielVM> requete(Void unused) {
    return this.listerTrimestre.listerTrimestre();
  }
}
