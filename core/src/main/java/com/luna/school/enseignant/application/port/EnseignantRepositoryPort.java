package com.luna.school.enseignant.application.port;


import com.luna.school.enseignant.domaine.entite.Enseignant;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-11-22
 */
public interface EnseignantRepositoryPort {

  boolean matriculeExiste(String matricule);

  void enregistrer(Enseignant enseignant);

  Enseignant recupererParId(UUID id);

  void supprimer(UUID enseignantId);
}
