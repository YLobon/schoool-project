package com.luna.school.query.classe;

import com.luna.school.classe.application.vm.ClasseDetailVM;
import com.luna.school.entite.ClasseTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.ClasseMapper;
import com.luna.school.repository.JpaClasseRepository;
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
public class QueryClasseDetail implements GestionnaireRequete<ClasseDetailVM, UUID> {

  private final JpaClasseRepository jpaClasseRepository;
  private final ClasseMapper classeMapper;

  public QueryClasseDetail(JpaClasseRepository jpaClasseRepository) {
    this.jpaClasseRepository = jpaClasseRepository;
    classeMapper = ClasseMapper.INSTANCE;
  }


  @Override
  public ClasseDetailVM requete(UUID id) {
    Optional<ClasseTable> classeTableOptional = this.jpaClasseRepository.findById(id);
    if (classeTableOptional.isPresent()) {
      var anneeScolaireTable = classeTableOptional.get();
      ClasseDetailVM classeDetailVM = this.classeMapper
          .classeTableVersClasseDetailVM(anneeScolaireTable);
      return classeDetailVM;
    }
    throw new NonTrouveException(
        "La classe  avec l'identifiant est " + id + " est introuvable !");
  }

}
