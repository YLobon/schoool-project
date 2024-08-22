package com.luna.school.trimestre.application.casutilisation;


import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ListerTrimestre {

  private final TrimestreRepositoryPort trimestreRepositoryPort;

  public ListerTrimestre(TrimestreRepositoryPort trimestreRepositoryPort) {
    this.trimestreRepositoryPort = trimestreRepositoryPort;
  }

  public List<TrimestreEssentielVM> listerTrimestre() {
    return this.trimestreRepositoryPort.lister();
  }
}
