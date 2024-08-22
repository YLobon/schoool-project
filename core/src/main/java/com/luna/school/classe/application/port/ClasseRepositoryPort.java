package com.luna.school.classe.application.port;

import com.luna.school.classe.application.vm.ClasseEssentielVM;
import com.luna.school.classe.domaine.entite.Classe;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public interface ClasseRepositoryPort {

  boolean existsParLibelle(String libelle);

  void enregistrer(Classe classe);

  Classe recupererParId(UUID classeId);

  List<ClasseEssentielVM> lister();

  boolean existeParId(UUID classeId);

  void supprimer(UUID classeId);

  List<Classe> recupererClasseParNiveauId(UUID niveauId);
}
