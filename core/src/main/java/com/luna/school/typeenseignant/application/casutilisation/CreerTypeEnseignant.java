package com.luna.school.typeenseignant.application.casutilisation;


import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.typeenseignant.application.commande.CreerTypeEnseignantCommande;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import com.luna.school.typeenseignant.domaine.entite.TypeEnseignant;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerTypeEnseignant {

  private final TypeEnseignantRepositoryPort typeEnseignantRepositoryPort;
  private final Logger logger = Logger.getLogger(CreerTypeEnseignant.class.getName());

  public CreerTypeEnseignant(TypeEnseignantRepositoryPort typeEnseignantRepositoryPort) {
    this.typeEnseignantRepositoryPort = typeEnseignantRepositoryPort;
  }


  public void creer(CreerTypeEnseignantCommande commande) {
    this.existeParLibelle(commande.getLibelle());
    var typeEnseignant = new TypeEnseignant();
    typeEnseignant.setId(UUID.randomUUID());
    typeEnseignant.setLibelle(commande.getLibelle());
    typeEnseignant.setTaxe(commande.getTaxe());
    typeEnseignant.setSalaireParHeure(commande.getSalaireParHeure());
    this.typeEnseignantRepositoryPort.enregistrer(typeEnseignant);
    logger.info("enregistrement effectué avec succès !");
  }


  private void existeParLibelle(String libelle) {
    boolean existeParLibelle = this.typeEnseignantRepositoryPort.existeParLibelle(libelle);
    if (existeParLibelle) {
      throw new AnneeScolaireException("ce libelle existe déjà !");
    }
  }
}