package com.luna.school.salaire.application.casutilisation;

import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import com.luna.school.salaire.application.commande.CreerSalaireCommande;
import com.luna.school.salaire.application.port.SalaireRepositoryPort;
import com.luna.school.salaire.domaine.entite.Salaire;
import com.luna.school.salaire.domaine.exception.SalaireException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-18
 */
public class PayerSalaire {

  private final SalaireRepositoryPort salaireRepositoryPort;
  private final PersonnelRepositoryPort personnelRepositoryPort;
  private final Logger logger = Logger.getLogger(PayerSalaire.class.getName());

  public PayerSalaire(SalaireRepositoryPort salaireRepositoryPort,
      PersonnelRepositoryPort personnelRepositoryPort) {
    this.salaireRepositoryPort = salaireRepositoryPort;
    this.personnelRepositoryPort = personnelRepositoryPort;
  }


  public void creer(CreerSalaireCommande commande) {
    Personnel personnel = this.recupererPersonnel(commande.getPersonnalId());
    var salaire = new Salaire();
    salaire.setId(UUID.randomUUID());
    salaire.setEstPayer(true);
    salaire.setPersonnel(personnel);
    salaire.setDatePaie(LocalDate.now());
    this.salaireRepositoryPort.enregistrer(salaire);
    logger.info("enregistrement effectué avec succès !");
  }

  private Personnel recupererPersonnel(UUID id){
    Personnel personnel = this.personnelRepositoryPort.recupererParId(id);
    if (Objects.nonNull(personnel) && personnel.getId() != null){
      return personnel;
    }else {
      throw new SalaireException("Cette personne n'existe pas");
    }
  }
}