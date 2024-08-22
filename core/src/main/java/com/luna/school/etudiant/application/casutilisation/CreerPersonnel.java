package com.luna.school.etudiant.application.casutilisation;

import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.etudiant.application.commande.CreerPersonnelCommande;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import java.util.Optional;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerPersonnel {
private final PersonnelRepositoryPort personnelRepositoryPort;
private final PaysRepositoryPort paysRepositoryPort;

  public CreerPersonnel(PersonnelRepositoryPort personnelRepositoryPort,
      PaysRepositoryPort paysRepositoryPort) {
    this.personnelRepositoryPort = personnelRepositoryPort;
    this.paysRepositoryPort = paysRepositoryPort;
  }

  public void creer(CreerPersonnelCommande commande){
    this.existeParMatricule(commande.getMatricule());
    Personnel personnel = this.genererPersonnel(commande);
    this.personnelRepositoryPort.enregistrer(personnel);
  }

  private Personnel genererPersonnel(CreerPersonnelCommande commande) {
    Pays pays = this.recupererPays(commande.getNationnailite());
    var personnel = new Personnel();
    personnel.setId(UUID.randomUUID());
    personnel.setCivilite(commande.getCivilite());
    personnel.setNationnailite(pays);
    personnel.setNom(commande.getNom());
    personnel.setPrenoms(commande.getPrenoms());
    personnel.setFonction(commande.getFonction());
    personnel.setMatricule(commande.getMatricule());
    personnel.setPiece(commande.getPiece());
    personnel.setResidence(commande.getResidence());
    personnel.setContact(commande.getContact());
    personnel.setNumeroPiece(commande.getNumeroPiece());
    return personnel;
  }
  private Pays recupererPays(UUID paysId){
    Optional<Pays> pays = this.paysRepositoryPort.recupererParId(paysId);
    if (pays.isEmpty()){
      throw new EnseignantException("le pays est introuvable !");
    }else {
      return pays.get();
    }
  }

  private void existeParMatricule(String matricule) {
    boolean existeParLibelle = this.personnelRepositoryPort.matriculeExiste(matricule);
    if (existeParLibelle){
      throw new EnseignantException("un personnel est déjè enregistré avec ce matricaule:"+matricule);
    }
  }
}
