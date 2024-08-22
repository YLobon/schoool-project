package com.luna.school.query.enseignant;

import com.luna.school.enseignant.application.vm.EnseignantDetailsVM;
import com.luna.school.entite.EnseignantTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.EnseignantMapper;
import com.luna.school.repository.JpaEnseignantRepository;
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
public class QueryEnseignantDetail implements GestionnaireRequete<EnseignantDetailsVM, UUID> {

  private final JpaEnseignantRepository enseignantRepository;
  private final EnseignantMapper enseignantMapper;

  public QueryEnseignantDetail(JpaEnseignantRepository enseignantRepository) {
    this.enseignantRepository = enseignantRepository;
    enseignantMapper = EnseignantMapper.INSTANCE;

  }


  @Override
  public EnseignantDetailsVM requete(UUID id) {
    Optional<EnseignantTable> enseignantTable = this.enseignantRepository.findById(id);
    if (enseignantTable.isPresent()) {
      var anneeScolaireTable = enseignantTable.get();
      return this.enseignantMapper
          .enseignantTableVersEnseignantDetailsVM(anneeScolaireTable);
    }
    throw new NonTrouveException(
        "L'enseignant avec l'identifiant " + id + " est introuvable !");
  }

}
