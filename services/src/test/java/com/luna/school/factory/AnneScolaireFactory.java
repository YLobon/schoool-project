package com.luna.school.factory;


import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.repository.JpaAnneeScolaireRepository;
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
public class AnneScolaireFactory {

  private final JpaAnneeScolaireRepository jpaAnneeScolaireRepository;

  public AnneScolaireFactory(JpaAnneeScolaireRepository jpaAnneeScolaireRepository) {
    this.jpaAnneeScolaireRepository = jpaAnneeScolaireRepository;
  }

  public AnneeScolaireTable anneScolaire(){
    var anneScolaire = new AnneeScolaireTable();
    anneScolaire.setId(UUID.randomUUID());
    anneScolaire.setLibelle("2024-2025");
    anneScolaire.setDateDebut(LocalDate.of(2025,1,2));
    anneScolaire.setDateFin(LocalDate.of(2025,5,12));
    return this.jpaAnneeScolaireRepository.save(anneScolaire);
  }
}
