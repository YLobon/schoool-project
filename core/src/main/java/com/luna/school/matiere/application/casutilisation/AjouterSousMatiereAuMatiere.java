package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.commande.AssocierSousMatiereAuMatiereCommande;
import com.luna.school.matiere.application.exception.MatiereException;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.matiere.domaine.entite.SousMatiere;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-04-10
 */
public class AjouterSousMatiereAuMatiere {

  private final SousMatiereRepositoryPort sousMatiereRepositoryPort;
  private final MatiereRepositoryPort matiereRepositoryPort;
  private final Logger logger = Logger.getLogger(AjouterSousMatiereAuMatiere.class.getName());

  public AjouterSousMatiereAuMatiere(SousMatiereRepositoryPort sousMatiereRepositoryPort,
      MatiereRepositoryPort matiereRepositoryPort) {
    this.sousMatiereRepositoryPort = sousMatiereRepositoryPort;
    this.matiereRepositoryPort = matiereRepositoryPort;
  }

  public void ajouterSousMatiere(AssocierSousMatiereAuMatiereCommande commande) {
    SousMatiere sousMatiere = this.sousMatiereRepositoryPort
        .recupererParId(commande.getSousMatiereId());
    Matiere matiere = this.matiereRepositoryPort.recupererParId(commande.getMatiereId());
    this.verifierMatiereExiste(matiere.getId());
    this.verifierLibelleParMatiere(matiere.getId());

    if (!matiere.isSousMatiere() || matiere.getSousMatieres() == null) {
      matiere.setSousMatieres(new ArrayList<>());
    }
    matiere.getSousMatieres().add(sousMatiere);

    if (matiere.isSousMatiere()){
      // Calcul de la note de la matière en fonction des sous-matières ajoutées
      double nouvelleNote = 0;
      for (SousMatiere sm : matiere.getSousMatieres()) {
        nouvelleNote += sm.getNote();
      }
      sousMatiere.setNote(nouvelleNote);
    }

    this.matiereRepositoryPort.enregistrer(matiere);
    logger.info("Sous matière ajoutée avec succès !");
  }

  private void verifierMatiereExiste(UUID matiereId) {
    Matiere matiere = this.matiereRepositoryPort.recupererParId(matiereId);
    if (matiere == null){
      throw new MatiereException("Cette matiere n'existe pas !");
    }
  }

  private void verifierLibelleParMatiere(UUID matiereId) {
    boolean existeParLibelle = this.matiereRepositoryPort
        .existsParId(matiereId);
    if (!existeParLibelle) {
      throw new MatiereException(
          "Le libelle "  + "existe déjà pour cette matiere !");
    }
  }
}
