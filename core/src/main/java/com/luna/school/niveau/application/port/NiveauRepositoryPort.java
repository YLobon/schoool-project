package com.luna.school.niveau.application.port;

import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import com.luna.school.niveau.domaine.entite.Niveau;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface NiveauRepositoryPort {
  boolean existeParNom(String nom);

  void enregistrer(Niveau niveau);

  Niveau recupererParId(UUID id);

  List<NiveauEssentielVM> lister();

  void supprimer(UUID niveauId);
}
