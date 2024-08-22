package com.luna.school.query.etudiant;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.etudiant.application.vm.StatistiqueVM;
import com.luna.school.mapper.StatistiqueMapper;
import com.luna.school.repository.JpaEtudianRepository;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.tools.NonTrouveException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-17 10:38 a.m..
 */
@Service
public class QueryStatistiqueVM implements GestionnaireRequete<StatistiqueVM, Void> {
  private final JpaEtudianRepository jpaEtudianRepository;
  private final StatistiqueMapper statistiqueMapper;

  public QueryStatistiqueVM(JpaEtudianRepository jpaEtudianRepository) {
    this.jpaEtudianRepository = jpaEtudianRepository;
    statistiqueMapper = StatistiqueMapper.INSTANCE;
  }


  @Override
  public StatistiqueVM requete(Void var1) throws NonTrouveException {
    List<EtudiantTable> etudiantTableList = this.jpaEtudianRepository.findAll();
    if(etudiantTableList.isEmpty()){
      throw new NonTrouveException("Aucun étudiant n'a été trouvé");
    }
    return this.statistiqueMapper.etudiantTableVersStatistiqueVM(etudiantTableList);
  }


}
