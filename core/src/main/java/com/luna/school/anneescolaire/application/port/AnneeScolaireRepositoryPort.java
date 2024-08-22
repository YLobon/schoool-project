package com.luna.school.anneescolaire.application.port;


import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface AnneeScolaireRepositoryPort {

  boolean existeParLibelle(String libelle);
  void enregistrer(AnneeScolaire anneeScolaire);

  Optional<AnneeScolaireDatailsVM> recupererVMParId(UUID id);
  Optional<AnneeScolaire> recupererParId(UUID id);
  List<AnneeScolaireEssentielVM> lister();

  void supprimer(UUID anneeScolaireId);
}
