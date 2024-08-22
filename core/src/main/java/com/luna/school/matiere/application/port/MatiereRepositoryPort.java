package com.luna.school.matiere.application.port;

import com.luna.school.matiere.domaine.entite.Matiere;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-10
 */
public interface MatiereRepositoryPort {

  void enregistrer(Matiere matiere);
  Matiere recupererParId(UUID id);

  boolean existeParNom(String nom);

  boolean existsParId(UUID id);

  void supprimer(UUID idMatiere);
}
