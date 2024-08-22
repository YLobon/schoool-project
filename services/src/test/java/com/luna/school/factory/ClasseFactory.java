package com.luna.school.factory;


import com.luna.school.entite.ClasseTable;
import com.luna.school.entite.NiveauTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.entite.SerieTable;
import com.luna.school.repository.JpaClasseRepository;
import java.util.Random;
import java.util.UUID;
import org.junit.runner.manipulation.Alphanumeric;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class ClasseFactory {

  private final JpaClasseRepository jpaClasseRepository;
  private final SerieFactory serieFactory;
  private final NiveauFactory niveauFactory;
  private final PersonnelFactory personnelFactory;

  public ClasseFactory(JpaClasseRepository jpaClasseRepository, SerieFactory serieFactory,
      NiveauFactory niveauFactory, PersonnelFactory personnelFactory) {
    this.jpaClasseRepository = jpaClasseRepository;
    this.serieFactory = serieFactory;
    this.niveauFactory = niveauFactory;
    this.personnelFactory = personnelFactory;
  }

  public ClasseTable classe() {
    NiveauTable niveau = this.niveauFactory.niveau();
    SerieTable serie = this.serieFactory.serie();
    PersonnelTable personnel = this.personnelFactory.personnel();
    var classe = new ClasseTable();
    classe.setId(UUID.randomUUID());
    classe.setLibelle("2e");
    classe.setSerie(serie);
    classe.setProfesseurPrincipal(personnel);
    classe.setNiveau(niveau);
    return this.jpaClasseRepository.save(classe);
  }
}
