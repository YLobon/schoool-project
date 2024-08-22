package com.luna.school.typeenseignant.application.port;


import com.luna.school.typeenseignant.domaine.entite.TypeEnseignant;
import java.util.Optional;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface TypeEnseignantRepositoryPort {

  boolean existeParLibelle(String libelle);

  void enregistrer(TypeEnseignant typeEnseignant);

  Optional<TypeEnseignant> recupererParId(UUID id);

  void supprimer(UUID typeEnseignantId);
}
