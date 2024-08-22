package com.luna.school.classe.application.gestionnairecommande;



import com.luna.school.classe.application.casutilisation.SupprimerClasse;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;

/**
 * @author BOUA YVES
 */
public class GestionnaireSupprimerClasse implements GestionnaireCommande<UUID> {

  private final SupprimerClasse supprimerClasse;

  public GestionnaireSupprimerClasse(
      ClasseRepositoryPort classeRepositoryPort
  ) {
    this.supprimerClasse = new SupprimerClasse(classeRepositoryPort);
  }

  @Override
  public void execute(UUID classeId) {
    this.supprimerClasse.supprimer(classeId);
  }
}
