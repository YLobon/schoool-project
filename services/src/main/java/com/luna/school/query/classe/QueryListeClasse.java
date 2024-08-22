package com.luna.school.query.classe;

import com.luna.school.classe.application.vm.ClasseEssentielVM;
import com.luna.school.entite.ClasseTable;
import com.luna.school.mapper.ClasseMapper;
import com.luna.school.repository.JpaClasseRepository;
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
public class QueryListeClasse implements GestionnaireRequete<List<ClasseEssentielVM>, Void> {
  private final JpaClasseRepository jpaClasseRepository;
  private final ClasseMapper classeMapper;

  public QueryListeClasse(JpaClasseRepository jpaClasseRepository) {
    this.jpaClasseRepository = jpaClasseRepository;
    classeMapper = ClasseMapper.INSTANCE;
  }

  @Override
  public List<ClasseEssentielVM> requete(Void var1){
    List<ClasseTable> classeTableList = this.jpaClasseRepository.findAll();
    return classeTableList.stream().map(this.classeMapper::classeTableVersClasseEssentielVM)
        .collect(Collectors.toList());
  }
}
