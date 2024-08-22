package com.luna.school.examen.application.port;


import com.luna.school.examen.domaine.entite.Examen;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface MatiereExamenRepositoryPort {

  boolean existeParLibelle(String libelle);

  void enregistrer(Examen examen);

  void supprimer(UUID examenId);

  Examen recupererParId(UUID examenId);
}
