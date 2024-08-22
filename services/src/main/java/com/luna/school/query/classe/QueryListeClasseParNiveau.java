package com.luna.school.query.classe;

import com.luna.school.classe.application.vm.ClasseDetailVM;
import com.luna.school.entite.ClasseTable;
import com.luna.school.mapper.ClasseMapper;
import com.luna.school.repository.JpaClasseRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListeClasseParNiveau implements
    GestionnaireRequete<List<ClasseDetailVM>, UUID> {

  private final JpaClasseRepository jpaClasseRepository;
  private final ClasseMapper classeMapper;

  public QueryListeClasseParNiveau(JpaClasseRepository jpaClasseRepository) {

    this.jpaClasseRepository = jpaClasseRepository;
    classeMapper = ClasseMapper.INSTANCE;
  }

  @Override
  public List<ClasseDetailVM> requete(UUID niveauId) {
    List<ClasseTable> classeTables = this.jpaClasseRepository
        .findByNiveauId(niveauId);
    return classeTables.stream()
        .map(this.classeMapper::classeTableVersClasseDetailVM).toList();
  }
}
