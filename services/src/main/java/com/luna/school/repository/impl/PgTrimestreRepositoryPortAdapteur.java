package com.luna.school.repository.impl;

import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.entite.TrimestreTable;
import com.luna.school.mapper.TrimestreMapper;
import com.luna.school.repository.JpaTrimestreRepository;
import com.luna.school.trimestre.application.exception.TrimestreException;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-26 11:29 a.m..
 */
@Repository
@Transactional
public class PgTrimestreRepositoryPortAdapteur implements TrimestreRepositoryPort {
  private final JpaTrimestreRepository jpaTrimestreRepository;
  private final TrimestreMapper trimestreMapper;

  public PgTrimestreRepositoryPortAdapteur(JpaTrimestreRepository jpaTrimestreRepository) {
    this.jpaTrimestreRepository = jpaTrimestreRepository;
    trimestreMapper = TrimestreMapper.INSTANCE;
  }

  @Override
  public boolean libellExiste(String libelle) {
    return this.jpaTrimestreRepository.existsByLibelle(libelle);
  }

  @Override
  public void enregistrer(Trimestre trimestre) {
    TrimestreTable trimestreTable = this.trimestreMapper.trimestreeVersTrimestreTable(trimestre);
    this.jpaTrimestreRepository.save(trimestreTable);
  }

  @Override
  public TrimestreDetailVM recupererTrimestreDetailVMParId(UUID id) {
     return null;
  }

  @Override
  public Trimestre recupererParId(UUID id) {
    TrimestreTable trimestreTable = this.jpaTrimestreRepository.findById(id)
        .orElseThrow(() -> new TrimestreException("Le trimestre n'existe pas !"));
    return this.trimestreMapper.trimestreTableVersTrimestre(trimestreTable);
  }



  @Override
  public List<TrimestreEssentielVM> lister() {
    List<TrimestreTable> trimestreTables = this.jpaTrimestreRepository.findAll();
    return trimestreTables.stream().map(this.trimestreMapper::trimestreTableVersTrimestreEssentielVM)
        .collect(Collectors.toList());
  }

  @Override
  public List<Trimestre> listerParAnneScolaire(UUID anneeScolaireId) {
    List<TrimestreTable> trimestreTables = this.jpaTrimestreRepository
        .findByAnneeScolaireId(anneeScolaireId);
    return trimestreTables.stream().map(this.trimestreMapper::trimestreTableVersTrimestre).toList();
  }

  @Override
  public void supprimer(UUID trmestreId) {
    try {
      this.jpaTrimestreRepository.deleteById(trmestreId);
    } catch (Exception e) {
      String message = "Impossible de supprimer!";
      throw new AnneeScolaireException(message);
    }

  }
}
