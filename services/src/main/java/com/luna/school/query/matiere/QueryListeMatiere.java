package com.luna.school.query.matiere;

import com.luna.school.entite.MatiereTable;
import com.luna.school.mapper.MatiereMapper;
import com.luna.school.matiere.application.vm.MatiereEssentielVM;
import com.luna.school.repository.JpaMatiereRepository;
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
public class QueryListeMatiere implements GestionnaireRequete<List<MatiereEssentielVM>, Void> {

  private final JpaMatiereRepository jpaMatiereRepository;
  private final MatiereMapper matiereMapper;

  public QueryListeMatiere(JpaMatiereRepository jpaMatiereRepository) {
    this.jpaMatiereRepository = jpaMatiereRepository;
    this.matiereMapper = MatiereMapper.INSTANCE;
  }

  @Override
  public List<MatiereEssentielVM> requete(Void var1) {
    List<MatiereTable> matiereTableList = this.jpaMatiereRepository.findAll();
    return matiereTableList.stream().map(this.matiereMapper::matiereTableVersMatiereEssentielVM)
        .collect(Collectors.toList());
  }
}
