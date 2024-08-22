package com.luna.school.factory;

import com.luna.school.entite.PaysTable;
import com.luna.school.mapper.PaysMapper;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.repository.JpaPaysRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-31 6:45 p.m..
 */
@Component
@Repository
public class PaysFactory {
private final JpaPaysRepository jpaPaysRepository;
private final PaysMapper paysMapper;

  public PaysFactory(JpaPaysRepository jpaPaysRepository) {
    this.jpaPaysRepository = jpaPaysRepository;
    paysMapper = PaysMapper.INSTANCE;
  }

  public PaysTable pays(){
    var pays = new PaysTable();
    pays.setId(UUID.randomUUID());
    pays.setNom("Côte d'Ivoire");
    return this.jpaPaysRepository.save(pays);
  }
  public Pays transformePaysTable(){
    var pays = new PaysTable();
    pays.setId(UUID.randomUUID());
    pays.setNom("Côte d'Ivoire");
    PaysTable paysTable = this.jpaPaysRepository.save(pays);
    return this.paysMapper.paysTableVersPays(paysTable);
  }
}
