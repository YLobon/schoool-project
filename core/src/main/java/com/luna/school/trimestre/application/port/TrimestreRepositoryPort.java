package com.luna.school.trimestre.application.port;

import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public interface TrimestreRepositoryPort {

  boolean libellExiste(String libelle);
  void enregistrer(Trimestre trimestre);
  TrimestreDetailVM recupererTrimestreDetailVMParId(UUID id);
  Trimestre recupererParId(UUID id);
  List<TrimestreEssentielVM> lister();
  List<Trimestre> listerParAnneScolaire(UUID anneeScolaireId);

  void supprimer(UUID annnscolaireID);
}
