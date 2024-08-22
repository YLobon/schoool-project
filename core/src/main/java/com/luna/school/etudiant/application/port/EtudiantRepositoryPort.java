package com.luna.school.etudiant.application.port;

import com.luna.school.etudiant.domaine.entite.Etudiant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface EtudiantRepositoryPort {

  boolean matriculeExiste(String matricule);

  void enregistrer(Etudiant etudiant);

  Etudiant recupererParId(UUID id);
}
