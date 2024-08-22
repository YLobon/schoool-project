package com.luna.school.factory;


import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.entite.TrimestreTable;
import com.luna.school.repository.JpaTrimestreRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class TrimestreFactory {

  private final JpaTrimestreRepository jpaTrimestreRepository;
  private final AnneScolaireFactory anneScolaireFactory;

  public TrimestreFactory(JpaTrimestreRepository jpaTrimestreRepository,
      AnneScolaireFactory anneScolaireFactory) {
    this.jpaTrimestreRepository = jpaTrimestreRepository;
    this.anneScolaireFactory = anneScolaireFactory;
  }


  public TrimestreTable trimestre(){
    AnneeScolaireTable anneeScolaireTable = this.anneScolaireFactory.anneScolaire();
    var trimestreTable = new TrimestreTable();
    trimestreTable.setId(UUID.randomUUID());
    trimestreTable.setLibelle("2024-2025");
    trimestreTable.setDateDebut(LocalDate.of(2025,2,12));
    trimestreTable.setDateFin(LocalDate.of(2025,5,12));
    trimestreTable.setAnneeScolaire(anneeScolaireTable);
    return this.jpaTrimestreRepository.save(trimestreTable);
  }
}
