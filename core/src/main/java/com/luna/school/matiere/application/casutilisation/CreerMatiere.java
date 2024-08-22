package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.commande.CreerMatiereCommande;
import com.luna.school.matiere.application.exception.MatiereException;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-10
 */
public class CreerMatiere {
  private final MatiereRepositoryPort matiereRepositoryPort;

  public CreerMatiere(MatiereRepositoryPort matiereRepositoryPort) {
    this.matiereRepositoryPort = matiereRepositoryPort;
  }

  public void Creer(CreerMatiereCommande commande){
    this.existeParLibelle(commande.getNom());
    Matiere matiere = this.genererMatier(commande);
    this.matiereRepositoryPort.enregistrer(matiere);
  }

  private Matiere genererMatier(CreerMatiereCommande commande){
    var matiere = new Matiere();
    matiere.setId(UUID.randomUUID());
    matiere.setNom(commande.getNom());
    matiere.setCoefficient(commande.getCoefficient());
    matiere.setSousMatiere(commande.isSousMatierePresent());
    return matiere;
  }


  private void existeParLibelle(String libelle) {
    boolean existeParLibelle = this.matiereRepositoryPort.existeParNom(libelle);
    if (existeParLibelle) {
      throw new MatiereException("ce libelle existe déjà !");
    }
  }
}
