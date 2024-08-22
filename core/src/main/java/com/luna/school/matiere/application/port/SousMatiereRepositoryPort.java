package com.luna.school.matiere.application.port;

import com.luna.school.matiere.domaine.entite.SousMatiere;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-10
 */
public interface SousMatiereRepositoryPort {

  void enregistrer(SousMatiere sousMatiere);

  SousMatiere recupererParId(UUID id);

  boolean existeParLibelle(String libelle);
  void supprimer(UUID id);
}
