package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.commande.ModifiereMatierCommande;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;

/**
 * @author BOUA YVES 2024-04-21
 */
public class ModifierMatiere {
  private final MatiereRepositoryPort matiereRepositoryPort;

  public ModifierMatiere(MatiereRepositoryPort matiereRepositoryPort) {
    this.matiereRepositoryPort = matiereRepositoryPort;
  }

  public void modifier(ModifiereMatierCommande commande) {
    Matiere matiere = this.matiereRepositoryPort.recupererParId(commande.getId());
    matiere.setNom(commande.getNom());
    matiere.setCoefficient(commande.getCoefficient());
    matiere.setSousMatiere(commande.isSousMatierePresent());
    this.matiereRepositoryPort.enregistrer(matiere);
  }
}
