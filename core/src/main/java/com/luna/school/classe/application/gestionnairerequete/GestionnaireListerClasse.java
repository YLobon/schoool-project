package com.luna.school.classe.application.gestionnairerequete;

import com.luna.school.classe.application.casutilisation.ListerClasse;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.application.vm.ClasseEssentielVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-12 9:37 a.m..
 */
public class GestionnaireListerClasse implements GestionnaireRequete<List<ClasseEssentielVM>, Void> {
private final ListerClasse listerClasse;

  public GestionnaireListerClasse(ClasseRepositoryPort classeRepositoryPort) {
    listerClasse = new ListerClasse(classeRepositoryPort);
  }

  @Override
  public List<ClasseEssentielVM> requete(Void var1) {
    return this.listerClasse.lister();
  }
}
