package com.luna.school.query.niveau;

import com.luna.school.entite.NiveauTable;
import com.luna.school.mapper.NiveauMapper;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import com.luna.school.repository.JpaNiveauRepository;
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
public class QueryListeNiveau implements GestionnaireRequete<List<NiveauEssentielVM>, Void> {
  private final JpaNiveauRepository jpaNiveauRepository;
  private final NiveauMapper niveauMapper;

  public QueryListeNiveau(JpaNiveauRepository jpaNiveauRepository) {
    this.jpaNiveauRepository = jpaNiveauRepository;
    this.niveauMapper = NiveauMapper.INSTANCE;
  }

  @Override
  public List<NiveauEssentielVM> requete(Void var1){
    List<NiveauTable> niveauTableList = this.jpaNiveauRepository.findAll();
    return niveauTableList.stream().map(this.niveauMapper::niveauTableVersNiveauEssentielVM)
        .collect(Collectors.toList());
  }
}
