package com.luna.school.repository.impl;

import com.luna.school.entite.PersonnelTable;
import com.luna.school.mapper.PersonnelMapper;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.application.vm.PersonnelEssentielVM;
import com.luna.school.personnel.domaine.entite.Personnel;
import com.luna.school.repository.JpaPersonnelRepository;
import com.luna.school.serie.application.exception.SerieException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 11:16 p.m..
 */
@Repository
public class PgPersonnelRepositoryAdapteur implements PersonnelRepositoryPort {

  private final JpaPersonnelRepository jpaPersonnelRepository;
  private final PersonnelMapper personnelMapper;

  public PgPersonnelRepositoryAdapteur(JpaPersonnelRepository jpaPersonnelRepository) {
    this.jpaPersonnelRepository = jpaPersonnelRepository;
    personnelMapper = PersonnelMapper.INSTANCE;
  }

  @Override
  public boolean matriculeExiste(String matricule) {
    return this.jpaPersonnelRepository.existsByMatricule(matricule);
  }

  @Override
  public void enregistrer(Personnel personnel) {
    PersonnelTable personnelTable = this.personnelMapper.personnelVersPersonnelTable(personnel);
    this.jpaPersonnelRepository.save(personnelTable);
  }

  @Override
  public Personnel recupererParId(UUID id) {
    PersonnelTable personnelTable = this.jpaPersonnelRepository.findById(id).orElseThrow(
        () -> new SerieException("Personnel introuvable !")
    );
    return this.personnelMapper.personnelTableVersPersonnel(personnelTable);
  }

  @Override
  public List<PersonnelEssentielVM> lister() {
    return this.jpaPersonnelRepository.findAll().stream()
        .map(this.personnelMapper::personnelTableVersPersonnelEssentielVM)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(UUID personnelId) {
try {
  this.jpaPersonnelRepository.deleteById(personnelId);
} catch (Exception e) {
  throw new RuntimeException(e);
}
  }
}
