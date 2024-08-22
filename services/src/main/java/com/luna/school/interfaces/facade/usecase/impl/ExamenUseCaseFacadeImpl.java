package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.examen.application.commande.CreerExamenCommande;
import com.luna.school.examen.application.gestionnairecommande.CreerExamenGestionnairecommande;
import com.luna.school.examen.application.port.ExamenRepositoryPort;
import com.luna.school.interfaces.facade.usecase.ExamenUseCaseFacade;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class ExamenUseCaseFacadeImpl implements ExamenUseCaseFacade {

  private final GestionnaireCommande<CreerExamenCommande> gestionnaireCreerExamen;


  public ExamenUseCaseFacadeImpl(NiveauRepositoryPort niveauRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort, ExamenRepositoryPort examenRepositoryPort) {
    gestionnaireCreerExamen = new CreerExamenGestionnairecommande(niveauRepositoryPort,
        classeRepositoryPort, examenRepositoryPort);
  }

  @Override
  public void creer(CreerExamenCommande commande) {
    this.gestionnaireCreerExamen.execute(commande);
  }
}
