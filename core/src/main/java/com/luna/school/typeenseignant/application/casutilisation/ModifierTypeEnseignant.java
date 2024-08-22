package com.luna.school.typeenseignant.application.casutilisation;


import com.luna.school.anneescolaire.application.casutilisation.CreerAnneeScolaire;
import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.typeenseignant.application.commande.ModifierTypeEnseignantCammande;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import com.luna.school.typeenseignant.domaine.entite.TypeEnseignant;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ModifierTypeEnseignant {

  private final Logger logger = Logger.getLogger(CreerAnneeScolaire.class.getName());
  private final TypeEnseignantRepositoryPort typeEnseignantRepositoryPort;

  public ModifierTypeEnseignant(TypeEnseignantRepositoryPort typeEnseignantRepositoryPort) {
    this.typeEnseignantRepositoryPort = typeEnseignantRepositoryPort;
  }


  public void modifier(ModifierTypeEnseignantCammande commande) {
    Optional<TypeEnseignant> typeEnseignantOptional = this.typeEnseignantRepositoryPort.recupererParId(
        commande.getId());
    if (typeEnseignantOptional.isEmpty()){
      throw new AnneeScolaireException("Le type de l'enseignant  est introuvable !");
    }
    TypeEnseignant typeEnseignant = typeEnseignantOptional.get();
    String libelle = commande.getLibelle();
    this.verifierLibelle(typeEnseignant,libelle);
    typeEnseignant.setLibelle(libelle);
    typeEnseignant.setSalaireParHeure(commande.getSalaireParHeure());
    typeEnseignant.setTaxe(commande.getTaxe());
    this.typeEnseignantRepositoryPort.enregistrer(typeEnseignant);
    logger.info("Le type enseignant a été modifier avec succès !");
  }

  private void verifierLibelle(TypeEnseignant typeEnseignant,String libelle) {
    boolean existeParLibelle = this.typeEnseignantRepositoryPort.existeParLibelle(libelle);
    if (existeParLibelle && !Objects.equals(typeEnseignant.getLibelle(), libelle)) {
      throw new AnneeScolaireException(
          "Le libelle " + libelle + " existe déjà pour une type d'enseignant !");
    }
  }
}
