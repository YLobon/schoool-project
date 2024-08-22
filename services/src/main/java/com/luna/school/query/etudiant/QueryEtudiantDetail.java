package com.luna.school.query.etudiant;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.etudiant.application.vm.EtudiantDetailVM;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.EtudiantMapper;
import com.luna.school.repository.JpaEtudianRepository;
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
public class QueryEtudiantDetail implements GestionnaireRequete<EtudiantDetailVM, UUID> {

  private final JpaEtudianRepository jpaEtudianRepository;
  private final EtudiantMapper etudiantMapper;

  public QueryEtudiantDetail(JpaEtudianRepository jpaEtudianRepository) {
    this.jpaEtudianRepository = jpaEtudianRepository;
    etudiantMapper = EtudiantMapper.INSTANCE;
  }

  @Override
  public EtudiantDetailVM requete(UUID id) {
    Optional<EtudiantTable> etudiantTableOptional = this.jpaEtudianRepository.findById(id);
    if (etudiantTableOptional.isPresent()) {
      EtudiantTable etudiantTable = etudiantTableOptional.get();
      var campagneDetailsVM = this.etudiantMapper
          .etudiantTableVersEtudiantDetailVM(etudiantTable);
      return campagneDetailsVM;
    }
    throw new NonTrouveException(
        "L'étudiant avec l'identifiant est " + id + " est introuvable !");
  }

}
