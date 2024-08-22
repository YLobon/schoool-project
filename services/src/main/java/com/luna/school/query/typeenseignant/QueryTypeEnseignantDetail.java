package com.luna.school.query.typeenseignant;

import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.TypeEnseignantMapper;
import com.luna.school.repository.JpaTypeEnseignantRepository;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantDatailsVM;
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
public class QueryTypeEnseignantDetail implements
    GestionnaireRequete<TypeEnseignantDatailsVM, UUID> {

  private final JpaTypeEnseignantRepository jpaTypeEnseignantRepository;
  private final TypeEnseignantMapper typeEnseignantMapper;

  public QueryTypeEnseignantDetail(JpaTypeEnseignantRepository jpaTypeEnseignantRepository) {
    this.jpaTypeEnseignantRepository = jpaTypeEnseignantRepository;
    typeEnseignantMapper = TypeEnseignantMapper.INSTANCE;
  }

  @Override
  public TypeEnseignantDatailsVM requete(UUID id) {
    Optional<TypeEnseignantTable> typeEnseignantTableOptional = this.jpaTypeEnseignantRepository
        .findById(id);
    if (typeEnseignantTableOptional.isPresent()) {
      var typeEnseignantTable = typeEnseignantTableOptional.get();
      var campagneDetailsVM = this.typeEnseignantMapper
          .typeEnseignantTableVersTypeEnseignantDatailsVM(typeEnseignantTable);
      return campagneDetailsVM;
    }
    throw new NonTrouveException(
        "Le type d'enseignant avec l'identifiant est " + id + " est introuvable !");
  }

}
