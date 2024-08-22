package com.luna.school.query.annneescolaire;

import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.AnneeScolaireMapper;
import com.luna.school.repository.JpaAnneeScolaireRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryAnneeScolaireDetail implements GestionnaireRequete<AnneeScolaireDatailsVM, UUID> {
private final JpaAnneeScolaireRepository jpaAnneeScolaireRepository;
private final AnneeScolaireMapper anneeScolaireMapper;

  public QueryAnneeScolaireDetail(JpaAnneeScolaireRepository jpaAnneeScolaireRepository) {
    this.jpaAnneeScolaireRepository = jpaAnneeScolaireRepository;
    this.anneeScolaireMapper = AnneeScolaireMapper.INSTANCE;
  }

  @Override
  public AnneeScolaireDatailsVM requete(UUID id) {
    Optional<AnneeScolaireTable> optionalAnneeScolaireTable = this.jpaAnneeScolaireRepository.findById(id);
    if (optionalAnneeScolaireTable.isPresent()) {
      var anneeScolaireTable = optionalAnneeScolaireTable.get();
      var campagneDetailsVM = this.anneeScolaireMapper
          .anneeScolaireTAbleVersAnneeScolaireDatailsVM(anneeScolaireTable);
      return campagneDetailsVM;
    }
    throw new NonTrouveException(
        "L'année  avec l'identifiant est " + id + " est introuvable !");
  }

}
