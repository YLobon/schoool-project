package com.luna.school.query.annneescolaire;

import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.mapper.AnneeScolaireMapper;
import com.luna.school.repository.JpaAnneeScolaireRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListeAnneeScolaire implements GestionnaireRequete<List<AnneeScolaireEssentielVM>, Void> {
private final JpaAnneeScolaireRepository jpaAnneeScolaireRepository;
private final AnneeScolaireMapper anneeScolaireMapper;

  public QueryListeAnneeScolaire(JpaAnneeScolaireRepository jpaAnneeScolaireRepository) {
    this.jpaAnneeScolaireRepository = jpaAnneeScolaireRepository;
    this.anneeScolaireMapper = AnneeScolaireMapper.INSTANCE;
  }

  @Override
  public List<AnneeScolaireEssentielVM> requete(Void var1){
    List<AnneeScolaireTable> anneeScolaireTables = this.jpaAnneeScolaireRepository.findAll();
    return anneeScolaireTables.stream().map(this.anneeScolaireMapper::anneeScolaireTAbleVersAnneeScolaireEssentielVM)
        .collect(Collectors.toList());
  }
}
