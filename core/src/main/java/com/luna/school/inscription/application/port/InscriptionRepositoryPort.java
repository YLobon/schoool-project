package com.luna.school.inscription.application.port;

import com.luna.school.inscription.domaine.entite.Inscription;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public interface InscriptionRepositoryPort {

  void enregistrer(Inscription inscription);

  Inscription recupereParId(UUID id);

  void supprimer(UUID idInscription);
  Inscription recupererInscriptionParEtudienId(UUID etudiantId);
}
