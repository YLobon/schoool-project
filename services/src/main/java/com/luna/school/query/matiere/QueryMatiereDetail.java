package com.luna.school.query.matiere;

import com.luna.school.entite.MatiereTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.MatiereMapper;
import com.luna.school.matiere.application.vm.MatiereDetailVM;
import com.luna.school.repository.JpaMatiereRepository;
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
public class QueryMatiereDetail implements GestionnaireRequete<MatiereDetailVM, UUID> {

  private final JpaMatiereRepository jpaMatiereRepository;
  private final MatiereMapper matiereMapper;

  public QueryMatiereDetail(JpaMatiereRepository jpaMatiereRepository) {
    this.jpaMatiereRepository = jpaMatiereRepository;
    this.matiereMapper = MatiereMapper.INSTANCE;
  }

  @Override
  public MatiereDetailVM requete(UUID id) {
    Optional<MatiereTable> matiereTableOptional = this.jpaMatiereRepository.findById(id);
    if (matiereTableOptional.isPresent()) {
      var matiereTable = matiereTableOptional.get();
      var matiereDetailsVM = this.matiereMapper
          .matiereTableVersMatiereDetailVM(matiereTable);
      return matiereDetailsVM;
    }
    throw new NonTrouveException(
        "La matiere avec l'identifiant est " + id + " est introuvable !");
  }

}
