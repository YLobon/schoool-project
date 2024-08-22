package com.luna.school.repository.impl;

import com.luna.school.entite.NiveauTable;
import com.luna.school.mapper.NiveauMapper;
import com.luna.school.niveau.application.exception.NiveauException;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.repository.JpaNiveauRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 11:08 p.m..
 */
@Repository
public class PgNiveauRepositoryAdapteur implements NiveauRepositoryPort {

  private final JpaNiveauRepository jpaNiveauRepository;
  private final NiveauMapper niveauMapper;

  public PgNiveauRepositoryAdapteur(JpaNiveauRepository jpaNiveauRepository) {
    this.jpaNiveauRepository = jpaNiveauRepository;
    niveauMapper = NiveauMapper.INSTANCE;
  }

  @Override
  public boolean existeParNom(String nom) {
    return this.jpaNiveauRepository.existsByNom(nom);
  }

  @Override
  public void enregistrer(Niveau niveau) {
    NiveauTable niveauTable = this.niveauMapper.niveauVersNiveauTable(niveau);
    this.jpaNiveauRepository.save(niveauTable);
  }

  @Override
  public Niveau recupererParId(UUID id) {
    NiveauTable niveauTable = this.jpaNiveauRepository.findById(id)
        .orElseThrow(() -> new NiveauException("Le niveau est introuvable !"));
    return this.niveauMapper.niveauTableVersNiveau(niveauTable);
  }

  @Override
  public List<NiveauEssentielVM> lister() {
    List<NiveauTable> niveauTableList = this.jpaNiveauRepository.findAll();
    return niveauTableList.stream()
        .map(this.niveauMapper::niveauTableVersNiveauEssentielVM).collect(Collectors.toList());
  }

  @Override
  public void supprimer(UUID niveauId) {
try{
  this.jpaNiveauRepository.deleteById(niveauId);
} catch (Exception e) {
  String message = "Impossible de faire cette suppression !";
  throw new NiveauException(message);
}
  }
}
