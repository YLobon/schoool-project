package com.luna.school.repository.examen.impl;

import com.luna.school.examen.application.port.MatiereExamenRepositoryPort;
import com.luna.school.examen.domaine.entite.Examen;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-30 2:57 p.m..
 */
@Repository
public class PgMatiereExamenRepositoryAdapteur implements
    MatiereExamenRepositoryPort {

  @Override
  public boolean existeParLibelle(String libelle) {
    return false;
  }

  @Override
  public void enregistrer(Examen examen) {

  }

  @Override
  public void supprimer(UUID examenId) {

  }

  @Override
  public Examen recupererParId(UUID examenId) {
    return null;
  }
}
