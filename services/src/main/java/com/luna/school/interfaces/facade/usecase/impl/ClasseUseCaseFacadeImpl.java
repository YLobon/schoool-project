package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.classe.application.commande.CreerClasseCommande;
import com.luna.school.classe.application.commande.ModifierClasseCommande;
import com.luna.school.classe.application.gestionnairecommande.GestionnaireCreerClasseCommande;
import com.luna.school.classe.application.gestionnairecommande.GestionnaireSupprimerClasse;
import com.luna.school.classe.application.gestionnairecommande.ModifierClasseGestionnairecommande;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.interfaces.facade.usecase.ClasseUseCaseFacade;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:18 a.m..
 */
@Service
public class ClasseUseCaseFacadeImpl implements ClasseUseCaseFacade {

  private final GestionnaireCommande<CreerClasseCommande>
      creerClasseCommandeGestionnaireCommande;
  private final GestionnaireCommande<ModifierClasseCommande>
      modifierClasseCommandeGestionnaireCommande;
  private final GestionnaireSupprimerClasse gestionnaireSupprimerClasse;

  public ClasseUseCaseFacadeImpl(ClasseRepositoryPort classeRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort, SerieRepositoryPort serieRepositoryPort,
      NiveauRepositoryPort niveauRepositoryPort) {
    this.creerClasseCommandeGestionnaireCommande =
        new GestionnaireCreerClasseCommande(classeRepositoryPort, enseignantRepositoryPort,
            serieRepositoryPort, niveauRepositoryPort);
    this.modifierClasseCommandeGestionnaireCommande =
        new ModifierClasseGestionnairecommande(classeRepositoryPort, niveauRepositoryPort,
            serieRepositoryPort, enseignantRepositoryPort);
    this.gestionnaireSupprimerClasse = new GestionnaireSupprimerClasse(classeRepositoryPort);
  }

  @Override
  public void creer(CreerClasseCommande commande) {
    this.creerClasseCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void modifier(ModifierClasseCommande commande) {
    this.modifierClasseCommandeGestionnaireCommande.execute(commande);
  }

  @Override
  public void supprimer(UUID id) {
    this.gestionnaireSupprimerClasse.execute(id);
  }
}
