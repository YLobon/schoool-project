package com.luna.school.query.personnel;

import com.luna.school.entite.PersonnelTable;
import com.luna.school.mapper.PersonnelMapper;
import com.luna.school.personnel.application.vm.PersonnelEssentielVM;
import com.luna.school.repository.JpaPersonnelRepository;
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
public class QueryListePersonnel implements GestionnaireRequete<List<PersonnelEssentielVM>, Void> {

  private final JpaPersonnelRepository jpaPersonnelRepository;
  private final PersonnelMapper personnelMapper;

  public QueryListePersonnel(JpaPersonnelRepository jpaPersonnelRepository) {
    this.jpaPersonnelRepository = jpaPersonnelRepository;
    personnelMapper = PersonnelMapper.INSTANCE;
  }


  @Override
  public List<PersonnelEssentielVM> requete(Void var1) {
    List<PersonnelTable> personnelTables = this.jpaPersonnelRepository.findAll();
    return personnelTables.stream()
        .map(this.personnelMapper::personnelTableVersPersonnelEssentielVM)
        .collect(Collectors.toList());
  }
}
