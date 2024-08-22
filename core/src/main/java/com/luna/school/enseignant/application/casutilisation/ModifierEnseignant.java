package com.luna.school.enseignant.application.casutilisation;

import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.typeenseignant.application.port.TypeEnseignantRepositoryPort;
import com.luna.school.typeenseignant.domaine.entite.TypeEnseignant;
import java.util.Optional;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-23
 */
public class ModifierEnseignant {

  private final EnseignantRepositoryPort enseignantRepositoryPort;
  private final TypeEnseignantRepositoryPort typeEnseignantRepositoryPort;
  private final PaysRepositoryPort paysRepositoryPort;

  public ModifierEnseignant(EnseignantRepositoryPort enseignantRepositoryPort,
      TypeEnseignantRepositoryPort typeEnseignantRepositoryPort,
      PaysRepositoryPort paysRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
    this.typeEnseignantRepositoryPort = typeEnseignantRepositoryPort;
    this.paysRepositoryPort = paysRepositoryPort;
  }

  public void modifier(ModifierEnseignantCommande commande) {
    Pays pays = this.recupererPays(commande.getNationnailiteId());
    TypeEnseignant typeEnseignant = this.recupererTypeEnseignant(commande.getTypeEnseignantId());
    Enseignant enseignant = this.enseignantRepositoryPort.recupererParId(commande.getId());
    enseignant.setNationnailite(pays);
    enseignant.setCivilite(commande.getCivilite());
    enseignant.setNom(commande.getNom());
    enseignant.setPrenoms(commande.getPrenoms());
    enseignant.setMatricule(commande.getMatricule());
    enseignant.setNumeroEnseignant(commande.getNumeroEnseignant());
    enseignant.setPiece(commande.getPiece());
    enseignant.setNumeroPiece(commande.getNumeroPiece());
    enseignant.setResidence(commande.getResidence());
    enseignant.setContact(commande.getContact());
    enseignant.setTypeEnseignant(typeEnseignant);
    this.enseignantRepositoryPort.enregistrer(enseignant);
  }


  private TypeEnseignant recupererTypeEnseignant(UUID id){
    Optional<TypeEnseignant> typeEnseignant = this.typeEnseignantRepositoryPort.recupererParId(id);
    if (typeEnseignant.isPresent()){
      return typeEnseignant.get();
    }else {
      throw new EnseignantException("le type de l'enseignant est introuvable");
    }
  }

  private Pays recupererPays(UUID id){
    Optional<Pays> paysOptional = this.paysRepositoryPort.recupererParId(id);
    if (paysOptional.isPresent()){
      return paysOptional.get();
    }else {
      throw new EnseignantException("le type de l'enseignant est introuvable");
    }
  }
}
