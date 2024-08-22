package com.luna.school.factory;


import com.luna.school.entite.SerieTable;
import com.luna.school.repository.JpaSerieRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class SerieFactory {

  private final JpaSerieRepository jpaSerieRepository;

  public SerieFactory(JpaSerieRepository jpaSerieRepository) {
    this.jpaSerieRepository = jpaSerieRepository;
  }


  public SerieTable serie(){
    var serieTable = new SerieTable();
    serieTable.setId(UUID.randomUUID());
    serieTable.setLibelle("Permier A2");
    return this.jpaSerieRepository.save(serieTable);
  }
}
