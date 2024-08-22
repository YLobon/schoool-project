package com.luna.school.repository.impl;

import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.entite.SousMatiereTable;
import com.luna.school.mapper.SousMatiereMapper;
import com.luna.school.matiere.application.port.SousMatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.SousMatiere;
import com.luna.school.repository.JpaSousMatiereRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 9:15 a.m..
 */
@Service
public class PgSousMatieRepositoryAdapteur implements SousMatiereRepositoryPort {

  private final JpaSousMatiereRepository jpaSousMatiereRepository;
  private final SousMatiereMapper sousMatiereMapper;

  public PgSousMatieRepositoryAdapteur(JpaSousMatiereRepository jpaSousMatiereRepository) {
    this.jpaSousMatiereRepository = jpaSousMatiereRepository;
    sousMatiereMapper = SousMatiereMapper.INSTANCE;
  }

  @Override
  public void enregistrer(SousMatiere sousMatiere) {
    SousMatiereTable sousMatiereTable = this.sousMatiereMapper.sousMatiereVersSousMatiereTable(
        sousMatiere);
    this.jpaSousMatiereRepository.save(sousMatiereTable);
  }

  @Override
  public SousMatiere recupererParId(UUID id) {
    Optional<SousMatiereTable> optionalSousMatiereTable = this.jpaSousMatiereRepository.findById(
        id);
    if (optionalSousMatiereTable.isPresent()) {
      SousMatiereTable sousMatiereTable = optionalSousMatiereTable.get();
      return sousMatiereMapper.sousMatiereTableVersSousMatiere(sousMatiereTable);
    } else {
      throw new ClasseExecption("La sous Matiere est introuvable !");
    }
  }

  @Override
  public boolean existeParLibelle(String nom) {
    return this.jpaSousMatiereRepository.existsByNomSousMatiere(nom);
  }


  @Override
  public void supprimer(UUID idMatiere) {
    try {
      this.jpaSousMatiereRepository.deleteById(idMatiere);
    } catch (Exception e) {
      String message = "impossible de supprimer cette Matiere !";
      throw new ClasseExecption(message);
    }
  }

}
