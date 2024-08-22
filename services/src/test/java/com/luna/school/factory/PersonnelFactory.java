package com.luna.school.factory;


import com.luna.school.entite.PaysTable;
import com.luna.school.entite.PersonnelTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.repository.JpaPersonnelRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class PersonnelFactory {

  private final JpaPersonnelRepository jpaPersonnelRepository;
  private final PaysFactory paysFactory;

  public PersonnelFactory(JpaPersonnelRepository jpaPersonnelRepository, PaysFactory paysFactory) {
    this.jpaPersonnelRepository = jpaPersonnelRepository;
    this.paysFactory = paysFactory;
  }

  public PersonnelTable personnel(){
    PaysTable pays = this.paysFactory.pays();
    var personnel = new PersonnelTable();
    personnel.setId(UUID.randomUUID());
    personnel.setCivilite(Civilite.MONSIEUR);
    personnel.setFonction("Educateur");
    personnel.setNom("BOUA");
    personnel.setPrenoms("Jules");
    personnel.setContact("0142804744");
    personnel.setMatricule("0048 698");
    personnel.setPiece(TypePiece.CNI);
    personnel.setNumeroPiece("09 2563 558 09");
    personnel.setNationnailite(pays);
    personnel.setResidence("Cocody");
    return this.jpaPersonnelRepository.save(personnel);
  }

}
