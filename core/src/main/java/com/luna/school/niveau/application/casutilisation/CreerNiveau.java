package com.luna.school.niveau.application.casutilisation;

import com.luna.school.niveau.application.commande.CreerNiveauCommande;
import com.luna.school.niveau.application.exception.NiveauException;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import com.luna.school.trimestre.application.exception.TrimestreException;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerNiveau {
private final NiveauRepositoryPort niveauRepositoryPort;
private final PersonnelRepositoryPort personnelRepositoryPort;

private final Logger logger = Logger.getLogger(CreerNiveau.class.getName());
  public CreerNiveau(NiveauRepositoryPort niveauRepositoryPort,
      PersonnelRepositoryPort personnelRepositoryPort) {
    this.niveauRepositoryPort = niveauRepositoryPort;
    this.personnelRepositoryPort = personnelRepositoryPort;
  }

  public void creer(CreerNiveauCommande commande){
    this.verifierNomNiveau(commande.getNom());
    Personnel personnel = this.personnelExiste(commande.getEducateurId());
    var niveau = new Niveau();
    niveau.setId(UUID.randomUUID());
    niveau.setNom(commande.getNom());
    niveau.setEducateur(personnel);
    niveau.setMontantScolarite(commande.getMontantScolarite());
    this.niveauRepositoryPort.enregistrer(niveau);
    logger.info("le niveau est enregistré avec succès !");
  }


  private void verifierNomNiveau(String nom) {
    boolean existeParLibelle = this.niveauRepositoryPort.existeParNom(nom);
    if (existeParLibelle) {
      throw new TrimestreException("Ce nom existe déjà pour un niveau !");
    }
  }

  private Personnel personnelExiste(UUID id){
    Personnel personnel = this.personnelRepositoryPort.recupererParId(id);
    if(personnel.getId() == null){
      throw new NiveauException("Cette personne n'existe pas !");
    }else {
      return personnel;
    }
  }
}
