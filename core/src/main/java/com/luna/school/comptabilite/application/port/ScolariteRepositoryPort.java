package com.luna.school.comptabilite.application.port;

import com.luna.school.comptabilite.domaine.entite.Scolarite;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public interface ScolariteRepositoryPort {

  boolean existsParLibelle(String libelle);

  void enregistrer(Scolarite scolarite);
  boolean existeParEtudiant(UUID etudiantId);
  Scolarite recupererParId(UUID id);
}
