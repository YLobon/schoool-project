package com.luna.school.query.sousmatiere;

import com.luna.school.entite.SousMatiereTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.SousMatiereMapper;
import com.luna.school.matiere.application.vm.SousMatiereDetailVM;
import com.luna.school.repository.JpaSousMatiereRepository;
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
public class QuerySousMatiereDetail implements GestionnaireRequete<SousMatiereDetailVM, UUID> {

  private final JpaSousMatiereRepository jpaSousMatiereRepository;
  private final SousMatiereMapper matiereMapper;

  public QuerySousMatiereDetail(JpaSousMatiereRepository jpaSousMatiereRepository) {
    this.jpaSousMatiereRepository = jpaSousMatiereRepository;
    this.matiereMapper = SousMatiereMapper.INSTANCE;
  }

  @Override
  public SousMatiereDetailVM requete(UUID id) {
    Optional<SousMatiereTable> optionalSousMatiereTable = this.jpaSousMatiereRepository.findById(
        id);
    if (optionalSousMatiereTable.isPresent()) {
      var matiereTable = optionalSousMatiereTable.get();
      var matiereDetailsVM = this.matiereMapper
          .sousMatiereTableVersSousMatiereDetailVM(matiereTable);
      return matiereDetailsVM;
    }
    throw new NonTrouveException(
        "La sous matiere avec l'identifiant est " + id + " est introuvable !");
  }

}
