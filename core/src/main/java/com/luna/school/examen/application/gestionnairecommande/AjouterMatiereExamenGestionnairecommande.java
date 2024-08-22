package com.luna.school.examen.application.gestionnairecommande;


import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.examen.application.casutilisation.AjouterMatiereExamen;
import com.luna.school.examen.application.commande.AjouterMatiereExamenCommande;
import com.luna.school.examen.application.port.ExamenRepositoryPort;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class AjouterMatiereExamenGestionnairecommande implements
    GestionnaireCommande<AjouterMatiereExamenCommande> {

  private final AjouterMatiereExamen ajouterMatiereExamen;

  public AjouterMatiereExamenGestionnairecommande(MatiereRepositoryPort matiereRepositoryPort,
      ExamenRepositoryPort examenRepositoryPort, ClasseRepositoryPort classeRepositoryPort) {
    this.ajouterMatiereExamen = new AjouterMatiereExamen(matiereRepositoryPort,
        examenRepositoryPort, classeRepositoryPort);
  }

  @Override
  public void execute(AjouterMatiereExamenCommande commande) {
this.ajouterMatiereExamen.ajouterMatiere(commande);
  }
}
