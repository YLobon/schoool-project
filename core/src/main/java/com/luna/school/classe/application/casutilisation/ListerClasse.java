package com.luna.school.classe.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.application.vm.ClasseEssentielVM;
import java.util.List;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 5:43 a.m..
 */
public class ListerClasse {
  private final ClasseRepositoryPort classeRepositoryPort;

  public ListerClasse(ClasseRepositoryPort classeRepositoryPort) {
    this.classeRepositoryPort = classeRepositoryPort;
  }

  public List<ClasseEssentielVM> lister(){
   return this.classeRepositoryPort.lister();
  }

}
