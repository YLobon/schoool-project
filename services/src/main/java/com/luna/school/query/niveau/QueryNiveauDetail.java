package com.luna.school.query.niveau;

import com.luna.school.entite.NiveauTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.NiveauMapper;
import com.luna.school.niveau.application.vm.NiveauDetailsVM;
import com.luna.school.repository.JpaNiveauRepository;
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
public class QueryNiveauDetail implements GestionnaireRequete<NiveauDetailsVM, UUID> {

  private final JpaNiveauRepository jpaNiveauRepository;
  private final NiveauMapper niveauMapper;

  public QueryNiveauDetail(JpaNiveauRepository jpaNiveauRepository) {
    this.jpaNiveauRepository = jpaNiveauRepository;
    this.niveauMapper = NiveauMapper.INSTANCE;
  }

  @Override
  public NiveauDetailsVM requete(UUID id) {
    Optional<NiveauTable> optionalNiveauTable = this.jpaNiveauRepository.findById(id);
    if (optionalNiveauTable.isPresent()) {
      var anneeScolaireTable = optionalNiveauTable.get();
      var niveauDetailsVM = this.niveauMapper
          .niveauTableVersNiveauDetailsVM(anneeScolaireTable);
      return niveauDetailsVM;
    }
    throw new NonTrouveException(
        "L'année  avec l'identifiant est " + id + " est introuvable !");
  }

}
