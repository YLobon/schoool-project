package com.luna.school.anneescolaire.application.casutilisation;


import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ModifierAnneeScolaire {

  private final Logger logger = Logger.getLogger(CreerAnneeScolaire.class.getName());
  private final AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;

  public ModifierAnneeScolaire(AnneeScolaireRepositoryPort anneeScolaireRepositoryPort) {
    this.anneeScolaireRepositoryPort = anneeScolaireRepositoryPort;
  }

  public void modifier(ModifierAnneeScolaireCammande commande) {
    Optional<AnneeScolaire> anneeScolaireOptional = this.anneeScolaireRepositoryPort.recupererParId(commande.getId());
    if (anneeScolaireOptional.isEmpty()){
      throw new AnneeScolaireException("L'année scolaire introuvable !");
    }
    AnneeScolaire anneeScolaire = anneeScolaireOptional.get();
    String libelle = commande.getLibelle();
    this.verifierLibelle(anneeScolaire,libelle);

    anneeScolaire.setLibelle(libelle);
    anneeScolaire.setDateDebut(commande.getDateDebut());
    anneeScolaire.setDateFin(commande.getDateFin());
    this.anneeScolaireRepositoryPort.enregistrer(anneeScolaire);
    logger.info("L'année scolaire modifier avec succès !");
  }

  private void verifierLibelle(AnneeScolaire anneeScolaire,String libelle) {
    boolean existeParLibelle = this.anneeScolaireRepositoryPort.existeParLibelle(libelle);
    if (existeParLibelle && !Objects.equals(anneeScolaire.getLibelle(), libelle)) {
      throw new AnneeScolaireException(
          "Le libelle " + libelle + " existe déjà pour une anné scolaire !");
    }
  }
}
