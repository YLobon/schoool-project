package com.luna.school.repository.impl;


import com.luna.school.entite.PaysTable;
import com.luna.school.mapper.PaysMapper;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.application.vm.PaysVM;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.repository.JpaPaysRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * @author BOUA YVES
 */
@Repository
public class PgPaysRepositoryAdapteur implements PaysRepositoryPort {


  private final JpaPaysRepository jpaPaysRepository;
  private final PaysMapper paysMapper;

  public PgPaysRepositoryAdapteur(JpaPaysRepository jpaPaysRepository) {
    this.jpaPaysRepository = jpaPaysRepository;
    this.paysMapper = PaysMapper.INSTANCE;
  }

  @Override
  public Optional<Pays> recupererParNom(String libelle) {
    Optional<PaysTable> optionalPaysTable = this.jpaPaysRepository.findByNom(libelle);
    return this.optionalPays(optionalPaysTable);
  }

  @Override
  public Optional<Pays> recupererParId(UUID id) {
    Optional<PaysTable> optionalPaysTable = this.jpaPaysRepository.findById(id);
    return this.optionalPays(optionalPaysTable);
  }

  @Override
  public List<PaysVM> lister() {
    List<PaysTable> paysTables = this.jpaPaysRepository.findAll();
    return paysTables.stream()
        .sorted(Comparator.comparing(PaysTable::getCreatedDate).reversed())
        .map(this.paysMapper::paysTableVersPaysVm)
        .collect(Collectors.toList());
  }

  @Override
  public boolean existeParNom(String nom) {
    return jpaPaysRepository.existsByNom(nom);
  }

  private Optional<Pays> optionalPays(Optional<PaysTable> optionalPaysTable) {
    return optionalPaysTable.map(this.paysMapper::paysTableVersPays);
  }
}
