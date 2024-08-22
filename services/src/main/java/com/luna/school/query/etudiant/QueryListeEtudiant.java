package com.luna.school.query.etudiant;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.etudiant.application.vm.EtudiantEssentielVM;
import com.luna.school.mapper.EtudiantMapper;
import com.luna.school.repository.JpaEtudianRepository;
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
public class QueryListeEtudiant implements GestionnaireRequete<List<EtudiantEssentielVM>, Void> {

  private final JpaEtudianRepository jpaEtudianRepository;
  private final EtudiantMapper etudiantMapper;

  public QueryListeEtudiant(JpaEtudianRepository jpaEtudianRepository) {
    this.jpaEtudianRepository = jpaEtudianRepository;
    etudiantMapper = EtudiantMapper.INSTANCE;
  }

  @Override
  public List<EtudiantEssentielVM> requete(Void var1) {
    List<EtudiantTable> etudiantTableList = this.jpaEtudianRepository.findAll();
    return etudiantTableList.stream().map(this.etudiantMapper::etudiantTableVersEtudiantEssentielVM)
        .collect(Collectors.toList());
  }
}
