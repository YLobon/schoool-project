package com.luna.school.query.sousmatiere;

import com.luna.school.entite.SousMatiereTable;
import com.luna.school.mapper.SousMatiereMapper;
import com.luna.school.matiere.application.vm.SousMatiereEssentielVM;
import com.luna.school.repository.JpaSousMatiereRepository;
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
public class QueryListeSousMatiere implements
    GestionnaireRequete<List<SousMatiereEssentielVM>, Void> {

  private final JpaSousMatiereRepository jpaSousMatiereRepository;
  private final SousMatiereMapper sousmatiereMapper;

  public QueryListeSousMatiere(JpaSousMatiereRepository jpaSousMatiereRepository) {
    this.jpaSousMatiereRepository = jpaSousMatiereRepository;
    this.sousmatiereMapper = SousMatiereMapper.INSTANCE;
  }

  @Override
  public List<SousMatiereEssentielVM> requete(Void var1) {

    List<SousMatiereTable> sousMatiereTableList = this.jpaSousMatiereRepository.findAll();
    return sousMatiereTableList.stream()
        .map(this.sousmatiereMapper::sousMatiereTableVersSousMatiereEssentielVM)
        .collect(Collectors.toList());
  }
}
