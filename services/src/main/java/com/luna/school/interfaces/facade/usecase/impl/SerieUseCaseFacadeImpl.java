package com.luna.school.interfaces.facade.usecase.impl;


import com.luna.school.interfaces.facade.usecase.SerieUseCaseFacade;
import com.luna.school.serie.application.casutilisation.SupprimerSerie;
import com.luna.school.serie.application.commande.CreerSerieCommande;
import com.luna.school.serie.application.commande.ModifierSerieCommande;
import com.luna.school.serie.application.gestionnairecommande.GestionnaireCreerSerieCommande;
import com.luna.school.serie.application.gestionnairecommande.GestionnaireModifierSerieCommande;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class SerieUseCaseFacadeImpl implements SerieUseCaseFacade {

  private final GestionnaireCommande<CreerSerieCommande> gestionnaireCreerSerie;
  private final GestionnaireCommande<ModifierSerieCommande> gestionnaireModifierSerie;
  private final SupprimerSerie supprimerSerieGestionnaire;

  public SerieUseCaseFacadeImpl(SerieRepositoryPort serieRepositoryPort) {
    gestionnaireCreerSerie = new GestionnaireCreerSerieCommande(serieRepositoryPort);
    gestionnaireModifierSerie = new GestionnaireModifierSerieCommande(serieRepositoryPort);
    this.supprimerSerieGestionnaire = new SupprimerSerie(
        serieRepositoryPort);
  }


  @Override
  public void creer(CreerSerieCommande commande) {
    this.gestionnaireCreerSerie.execute(commande);
  }

  @Override
  public void modifier(ModifierSerieCommande commande) {
    this.gestionnaireModifierSerie.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.supprimerSerieGestionnaire.supprimer(id);
  }
}
