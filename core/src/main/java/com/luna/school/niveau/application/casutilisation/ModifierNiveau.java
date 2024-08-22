package com.luna.school.niveau.application.casutilisation;

import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.niveau.application.commande.ModifierNiveauCommande;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.domaine.entite.Niveau;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-27
 */
public class ModifierNiveau {

  private final Logger logger = Logger.getLogger(ModifierNiveau.class.getName());
  private final NiveauRepositoryPort niveauRepositoryPort;

  public ModifierNiveau(NiveauRepositoryPort niveauRepositoryPort) {
    this.niveauRepositoryPort = niveauRepositoryPort;
  }

  public void modifier(ModifierNiveauCommande commande) {
    Niveau niveau = this.niveauRepositoryPort.recupererParId(commande.getId());
    String nom = commande.getNom();
    this.verifierNom(niveau, nom);
    niveau.setNom(nom);
    niveau.setMontantScolarite(commande.getMontantScolarite());
    this.niveauRepositoryPort.enregistrer(niveau);
    logger.info("Niveau modifié avec succès !");
  }


  private void verifierNom(Niveau niveau, String nom) {
    boolean existeParLibelle = this.niveauRepositoryPort.existeParNom(nom);
    if (existeParLibelle && !Objects.equals(niveau.getNom(), nom)) {
      throw new AnneeScolaireException(
          "Le libelle " + nom + " existe déjà pour une anné scolaire !");
    }
  }
}
