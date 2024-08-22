package com.luna.school.pays.application.port;


import com.luna.school.pays.application.vm.PaysVM;
import com.luna.school.pays.domaine.entite.Pays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * {@inheritDoc}
 *
 * @author Anderson Ouattara 2023-09-20
 */
public interface PaysRepositoryPort {
  Optional<Pays> recupererParNom(String libelle);
  Optional<Pays> recupererParId(UUID id);
  List<PaysVM> lister();
  boolean existeParNom(String nom);

}
