package com.luna.school.query.personnel;

import com.luna.school.entite.PersonnelTable;
import com.luna.school.exception.NonTrouveException;
import com.luna.school.mapper.PersonnelMapper;
import com.luna.school.personnel.application.vm.PersonnelDetailVM;
import com.luna.school.repository.JpaPersonnelRepository;
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
public class QueryPersonnelDetail implements GestionnaireRequete<PersonnelDetailVM, UUID> {

  private final JpaPersonnelRepository jpaPersonnelRepository;
  private final PersonnelMapper personnelMapper;

  public QueryPersonnelDetail(JpaPersonnelRepository jpaPersonnelRepository) {
    this.jpaPersonnelRepository = jpaPersonnelRepository;
    personnelMapper = PersonnelMapper.INSTANCE;
  }

  @Override
  public PersonnelDetailVM requete(UUID id) {
    Optional<PersonnelTable> personnelTableOptionaln = this.jpaPersonnelRepository.findById(id);
    if (personnelTableOptionaln.isPresent()) {
      var anneeScolaireTable = personnelTableOptionaln.get();
      var personnelDetailVM = this.personnelMapper
          .personnelTableVersPersonnelDetailVM(anneeScolaireTable);
      return personnelDetailVM;
    }
    throw new NonTrouveException(
        "Le personnel avec l'identifiant est " + id + " est introuvable !");
  }

}
