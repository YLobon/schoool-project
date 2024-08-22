package com.luna.school.query.typeenseignant;

import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.mapper.TypeEnseignantMapper;
import com.luna.school.repository.JpaTypeEnseignantRepository;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantEssentielVM;
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
public class QueryListeTypeEnseignant implements
    GestionnaireRequete<List<TypeEnseignantEssentielVM>, Void> {

  private final JpaTypeEnseignantRepository jpaTypeEnseignantRepository;
  private final TypeEnseignantMapper typeEnseignantMapper;

  public QueryListeTypeEnseignant(JpaTypeEnseignantRepository jpaTypeEnseignantRepository) {
    this.jpaTypeEnseignantRepository = jpaTypeEnseignantRepository;
    typeEnseignantMapper = TypeEnseignantMapper.INSTANCE;
  }

  @Override
  public List<TypeEnseignantEssentielVM> requete(Void var1) {
    List<TypeEnseignantTable> typeEnseignantTables = this.jpaTypeEnseignantRepository.findAll();
    return typeEnseignantTables.stream()
        .map(this.typeEnseignantMapper::typeEnseignantTableVersTypeEnseignantEssentielVM)
        .collect(Collectors.toList());
  }
}
