package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.commande.CreerSousMatiereComande;
import com.luna.school.matiere.application.exception.MatiereException;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.SousMatiere;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-10
 */
public class CreerSousMatiere {
  private final SousMatiereRepositoryPort sousMatiereRepositoryPort;

  public CreerSousMatiere(SousMatiereRepositoryPort sousMatiereRepositoryPort) {
    this.sousMatiereRepositoryPort = sousMatiereRepositoryPort;
  }


  public void Creer(CreerSousMatiereComande commande){

    this.existeParLibelle(commande.getNomSousMatiere());
    SousMatiere sousMatiere = this.genererSousMatiere(commande);
    this.sousMatiereRepositoryPort.enregistrer(sousMatiere);
  }

  private SousMatiere genererSousMatiere(CreerSousMatiereComande commande){
    var sousMatiere = new SousMatiere();
    sousMatiere.setId(UUID.randomUUID());
    sousMatiere.setNom(commande.getNomSousMatiere());
    sousMatiere.setNote(commande.getNote());
    return sousMatiere;
  }


  private void existeParLibelle(String libelle) {
    boolean existeParLibelle = this.sousMatiereRepositoryPort.existeParLibelle(libelle);
    if (existeParLibelle) {
      throw new MatiereException("ce libelle existe déjà !");
    }
  }
}
