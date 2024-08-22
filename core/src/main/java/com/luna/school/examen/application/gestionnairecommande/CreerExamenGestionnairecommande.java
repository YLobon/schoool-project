package com.luna.school.examen.application.gestionnairecommande;


import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.examen.application.casutilisation.CreerExamen;
import com.luna.school.examen.application.commande.CreerExamenCommande;
import com.luna.school.examen.application.port.ExamenRepositoryPort;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerExamenGestionnairecommande implements
    GestionnaireCommande<CreerExamenCommande> {

  private final CreerExamen creerExamen;

  public CreerExamenGestionnairecommande(NiveauRepositoryPort niveauRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort, ExamenRepositoryPort examenRepositoryPort) {
    this.creerExamen = new CreerExamen(niveauRepositoryPort, classeRepositoryPort,
        examenRepositoryPort);
  }

  @Override
  public void execute(CreerExamenCommande commande) {
    this.creerExamen.creerExamen(commande);
  }
}
