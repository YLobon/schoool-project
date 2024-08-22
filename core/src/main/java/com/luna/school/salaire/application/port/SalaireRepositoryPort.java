package com.luna.school.salaire.application.port;

import com.luna.school.salaire.domaine.entite.Salaire;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-02
 */
public interface SalaireRepositoryPort {

  boolean existeParLibelle(String libelle);

  void enregistrer(Salaire serie);

  Salaire recupererParId(UUID id);

  void supprimer(UUID serieId);
}
