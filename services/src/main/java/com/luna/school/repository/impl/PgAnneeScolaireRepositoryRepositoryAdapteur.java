package com.luna.school.repository.impl;


import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.mapper.AnneeScolaireMapper;
import com.luna.school.repository.JpaAnneeScolaireRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * @author BOUA YVES 2024-03-21
 */
@Repository
public class PgAnneeScolaireRepositoryRepositoryAdapteur implements AnneeScolaireRepositoryPort {

  private final JpaAnneeScolaireRepository jpaAnneeScolaireRepository;
  private final AnneeScolaireMapper anneeScolaireMapper;

  public PgAnneeScolaireRepositoryRepositoryAdapteur(JpaAnneeScolaireRepository jpaAnneeScolaireRepository) {
    this.jpaAnneeScolaireRepository = jpaAnneeScolaireRepository;
    anneeScolaireMapper = AnneeScolaireMapper.INSTANCE;
  }

  @Override
  public boolean existeParLibelle(String libelle) {
//    return true;
    return this.jpaAnneeScolaireRepository.existsByLibelle(libelle);
  }

  @Override
  public void enregistrer(AnneeScolaire anneeScolaire) {
    AnneeScolaireTable anneeScolaireTable = this.anneeScolaireMapper.anneeScolaireVersAnneeScolaireTable(
        anneeScolaire);
    this.jpaAnneeScolaireRepository.save(anneeScolaireTable);
  }

  @Override
  public Optional<AnneeScolaireDatailsVM> recupererVMParId(UUID id) {
    return this.jpaAnneeScolaireRepository.findById(id)
        .map(this.anneeScolaireMapper::anneeScolaireTAbleVersAnneeScolaireDatailsVM);
  }

  @Override
  public Optional<AnneeScolaire> recupererParId(UUID id) {
    Optional<AnneeScolaireTable> optionnalAnneScolaire = this.jpaAnneeScolaireRepository.findById(id);
    return this.optionnalAnneScolaire(optionnalAnneScolaire);
  }

  private Optional<AnneeScolaire> optionnalAnneScolaire(Optional<AnneeScolaireTable> optionalAnneeScolaireTable) {
    return optionalAnneeScolaireTable.map(this.anneeScolaireMapper::anneeScolaireTableVersAnneeScolaire);
  }


  @Override
  public List<AnneeScolaireEssentielVM> lister() {
    List<AnneeScolaireTable> anneeScolaireList = this.jpaAnneeScolaireRepository.findAll();
    return anneeScolaireList.stream()
        .map(this.anneeScolaireMapper::anneeScolaireTAbleVersAnneeScolaireEssentielVM).collect(
            Collectors.toList());
  }

  @Override
  public void supprimer(UUID anneeScolaireId) {
    try {
      this.jpaAnneeScolaireRepository.deleteById(anneeScolaireId);
    } catch (Exception e) {
      String message = "Im,"
          + "  des entités!";
      throw new AnneeScolaireException(message);
    }
  }
}
