package com.luna.school.classe.application.casutilisation;


import com.luna.school.classe.application.port.ClasseRepositoryPort;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */

public class SupprimerClasse {
  private final ClasseRepositoryPort classeRepositoryPort;

  public SupprimerClasse(ClasseRepositoryPort classeRepositoryPort) {
    this.classeRepositoryPort = classeRepositoryPort;
  }


  public void supprimer(UUID classeId) {
    this.classeRepositoryPort.supprimer(classeId);
  }


}
