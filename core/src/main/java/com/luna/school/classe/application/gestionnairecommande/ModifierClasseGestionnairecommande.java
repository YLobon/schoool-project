package com.luna.school.classe.application.gestionnairecommande;


import com.luna.school.classe.application.casutilisation.ModifierClasse;
import com.luna.school.classe.application.commande.ModifierClasseCommande;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class ModifierClasseGestionnairecommande implements
    GestionnaireCommande<ModifierClasseCommande> {

  private final ModifierClasse modifierClasse;

  public ModifierClasseGestionnairecommande(
      ClasseRepositoryPort classeRepositoryPort,
      NiveauRepositoryPort niveauRepositoryPort, SerieRepositoryPort serieRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort) {
    this.modifierClasse = new ModifierClasse(classeRepositoryPort, niveauRepositoryPort,
        serieRepositoryPort, enseignantRepositoryPort);
  }

  @Override
  public void execute(ModifierClasseCommande commande) {
    this.modifierClasse.modifier(commande);
  }
}
