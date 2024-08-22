package com.luna.school.etudiant.application.port;

import com.luna.school.etudiant.domaine.entite.ParentEtudiant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface ParentEtudiantRepositoryPort {

  void enregistrer(ParentEtudiant pereEtudiant);

  ParentEtudiant recupererParId(UUID id);
}
