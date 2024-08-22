package com.luna.school.query.etudiant;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.etudiant.application.vm.EtudiantDetailVM;
import com.luna.school.mapper.EtudiantMapper;
import com.luna.school.repository.JpaEtudianRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 10:42 a.m..
 */
@Service
public class QueryListeEtudiantParSexe implements
    GestionnaireRequete<List<EtudiantDetailVM>, Civilite> {

  private final JpaEtudianRepository jpaEtudianRepository;
  private final EtudiantMapper etudiantMapper;

  public QueryListeEtudiantParSexe(JpaEtudianRepository jpaEtudianRepository) {
    this.jpaEtudianRepository = jpaEtudianRepository;
    etudiantMapper = EtudiantMapper.INSTANCE;
  }

  @Override
  public List<EtudiantDetailVM> requete(Civilite civilite) {
    List<EtudiantTable> etudiantTableList = this.jpaEtudianRepository
        .findByCivilite(civilite);
    return etudiantTableList.stream()
        .map(this.etudiantMapper::etudiantTableVersEtudiantDetailVM).toList();
  }
}
