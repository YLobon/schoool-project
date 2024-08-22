package com.luna.school.classe.application.gestionnairecommande;

import com.luna.school.classe.application.casutilisation.CreerClasse;
import com.luna.school.classe.application.commande.CreerClasseCommande;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 5:37 a.m..
 */
public class GestionnaireCreerClasseCommande implements GestionnaireCommande<CreerClasseCommande> {

  private final CreerClasse creerClasse;

  public GestionnaireCreerClasseCommande(ClasseRepositoryPort classeRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort, SerieRepositoryPort serieRepositoryPort,
      NiveauRepositoryPort niveauRepositoryPort) {
    creerClasse = new CreerClasse(classeRepositoryPort, niveauRepositoryPort, serieRepositoryPort,
        enseignantRepositoryPort);
  }

  @Override
  public void execute(CreerClasseCommande commande) {
    this.creerClasse.creer(commande);
  }
}
