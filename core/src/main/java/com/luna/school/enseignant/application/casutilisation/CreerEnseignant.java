package com.luna.school.enseignant.application.casutilisation;

import com.luna.school.enseignant.application.commande.CreerEnseignantCommande;
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
public class CreerEnseignant {

  private final EnseignantRepositoryPort enseignantRepositoryPort;
  private final TypeEnseignantRepositoryPort typeEnseignantRepositoryPort;
  private final PaysRepositoryPort paysRepositoryPort;

  public CreerEnseignant(EnseignantRepositoryPort enseignantRepositoryPort,
      TypeEnseignantRepositoryPort typeEnseignantRepositoryPort,
      PaysRepositoryPort paysRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
    this.typeEnseignantRepositoryPort = typeEnseignantRepositoryPort;
    this.paysRepositoryPort = paysRepositoryPort;
  }

  public void creer(CreerEnseignantCommande commande) {
    this.existeParMatricule(commande.getMatricule());
    Enseignant enseignant = this.genererEnseignant(commande);
    this.enseignantRepositoryPort.enregistrer(enseignant);
  }

  private Enseignant genererEnseignant(CreerEnseignantCommande commande) {
    Pays pays = this.recupererPays(commande.getNationnailiteId());
    TypeEnseignant typeEnseignant = this.recupererTypeEnseignant(commande.getTypeEnseignantId());
    var enseignant = new Enseignant();
    enseignant.setId(UUID.randomUUID());
    enseignant.setCivilite(commande.getCivilite());
    enseignant.setNationnailite(pays);
    enseignant.setNom(commande.getNom());
    enseignant.setPrenoms(commande.getPrenoms());
    enseignant.setMatricule(commande.getMatricule());
    enseignant.setNumeroEnseignant(commande.getNumeroEnseignant());
    enseignant.setPiece(commande.getPiece());
    enseignant.setResidence(commande.getResidence());
    enseignant.setSpecialite(commande.getSpecialite());
    enseignant.setContact(commande.getContact());
    enseignant.setNumeroPiece(commande.getNumeroPiece());
    enseignant.setTypeEnseignant(typeEnseignant);
    return enseignant;
  }

  private void existeParMatricule(String matricule) {
    boolean existeParLibelle = this.enseignantRepositoryPort.matriculeExiste(matricule);
    if (existeParLibelle) {
      throw new EnseignantException(
          "un enseignant est déjè enregistré avec ce matricaule:" + matricule);
    }
  }

  private TypeEnseignant recupererTypeEnseignant(UUID id) {
    Optional<TypeEnseignant> typeEnseignant = this.typeEnseignantRepositoryPort.recupererParId(id);
    if (typeEnseignant.isPresent()) {
      return typeEnseignant.get();
    } else {
      throw new EnseignantException("le type de l'enseignant est introuvable");
    }
  }

  private Pays recupererPays(UUID id) {
    Optional<Pays> paysOptional = this.paysRepositoryPort.recupererParId(id);
    if (paysOptional.isPresent()) {
      return paysOptional.get();
    } else {
      throw new EnseignantException("le type de l'enseignant est introuvable");
    }
  }
}
