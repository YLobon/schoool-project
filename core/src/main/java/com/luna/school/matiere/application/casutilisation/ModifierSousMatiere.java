package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.commande.ModifierSousMatierCommande;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.SousMatiere;

/**
 * @author BOUA YVES 2024-04-21
 */

public class ModifierSousMatiere {

  private final SousMatiereRepositoryPort sousMatiereRepositoryPort;

  public ModifierSousMatiere(SousMatiereRepositoryPort sousMatiereRepositoryPort) {
    this.sousMatiereRepositoryPort = sousMatiereRepositoryPort;
  }

  public void modifier(ModifierSousMatierCommande commande) {
    SousMatiere sousMatiere = this.sousMatiereRepositoryPort.recupererParId(commande.getId());
    sousMatiere.setNom(commande.getNomSousMatiere());
    sousMatiere.setNote(commande.getNote());
    this.sousMatiereRepositoryPort.enregistrer(sousMatiere);
  }
}
