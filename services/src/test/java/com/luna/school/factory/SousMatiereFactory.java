package com.luna.school.factory;


import com.luna.school.entite.SousMatiereTable;
import com.luna.school.repository.JpaSousMatiereRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class SousMatiereFactory {

  private final JpaSousMatiereRepository jpaSousMatiereRepository;

  public SousMatiereFactory(JpaSousMatiereRepository jpaSousMatiereRepository) {
    this.jpaSousMatiereRepository = jpaSousMatiereRepository;
  }

  public SousMatiereTable sousMatiere() {
    var sousMatiere = new SousMatiereTable();
    sousMatiere.setId(UUID.randomUUID());
    sousMatiere.setNomSousMatiere("expression orale");
    sousMatiere.setNote(18);
    return this.jpaSousMatiereRepository.save(sousMatiere);
  }

  public SousMatiereTable sousMatiere2() {
    var sousMatiere = new SousMatiereTable();
    sousMatiere.setId(UUID.randomUUID());
    sousMatiere.setNomSousMatiere("Composition française");
    sousMatiere.setNote(14);
    return this.jpaSousMatiereRepository.save(sousMatiere);
  }

  public SousMatiereTable sousMatiere3() {
    var sousMatiere = new SousMatiereTable();
    sousMatiere.setId(UUID.randomUUID());
    sousMatiere.setNomSousMatiere("Grammaire");
    sousMatiere.setNote(12);
    return this.jpaSousMatiereRepository.save(sousMatiere);
  }
}
