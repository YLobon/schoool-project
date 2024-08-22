package com.luna.school.factory;


import com.luna.school.entite.NiveauTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.repository.JpaNiveauRepository;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class NiveauFactory {

  private final JpaNiveauRepository jpaNiveauRepository;
  private final PersonnelFactory personnelFactory;

  public NiveauFactory(JpaNiveauRepository jpaNiveauRepository, PersonnelFactory personnelFactory) {
    this.jpaNiveauRepository = jpaNiveauRepository;
    this.personnelFactory = personnelFactory;
  }

  public NiveauTable niveau(){
    PersonnelTable personnel = this.personnelFactory.personnel();
    var niveau = new NiveauTable();
    niveau.setId(UUID.randomUUID());
    niveau.setNom("PREMIERE G2");
    niveau.setEducateur(personnel);
    niveau.setMontantScolarite(BigDecimal.valueOf(200000.0));
    return this.jpaNiveauRepository.save(niveau);
  }

}
