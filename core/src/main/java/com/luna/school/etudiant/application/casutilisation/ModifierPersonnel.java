package com.luna.school.etudiant.application.casutilisation;

import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.etudiant.application.commande.ModifierPersonnelCommande;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import java.util.Optional;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-23
 */

public class ModifierPersonnel {

  private final PersonnelRepositoryPort personnelRepositoryPort;
  private final PaysRepositoryPort paysRepositoryPort;

  public ModifierPersonnel(PersonnelRepositoryPort personnelRepositoryPort,
      PaysRepositoryPort paysRepositoryPort) {
    this.personnelRepositoryPort = personnelRepositoryPort;
    this.paysRepositoryPort = paysRepositoryPort;
  }

  public void modifier(ModifierPersonnelCommande commande) {
    Pays pays = this.recupererPays(commande.getNationnailite());
    Personnel personnel = this.personnelRepositoryPort.recupererParId(commande.getId());
    personnel.setNationnailite(pays);
    personnel.setCivilite(commande.getCivilite());
    personnel.setNom(commande.getNom());
    personnel.setPrenoms(commande.getPrenoms());
    personnel.setMatricule(commande.getMatricule());
    personnel.setPiece(commande.getPiece());
    personnel.setNumeroPiece(commande.getNumeroPiece());
    personnel.setResidence(commande.getResidence());
    personnel.setContact(commande.getContact());
    this.personnelRepositoryPort.enregistrer(personnel);
  }

  private Pays recupererPays(UUID paysId){
    Optional<Pays> pays = this.paysRepositoryPort.recupererParId(paysId);
    if (pays.isEmpty()){
      throw new EnseignantException("le pays est introuvable !");
    }else {
      return pays.get();
    }
  }
}
