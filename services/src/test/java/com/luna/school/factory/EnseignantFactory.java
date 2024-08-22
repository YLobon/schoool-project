package com.luna.school.factory;

import com.luna.school.entite.EnseignantTable;
import com.luna.school.entite.PaysTable;
import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.repository.JpaEnseignantRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-17 5:42 p.m..
 */
@Component
public class EnseignantFactory {
  private final JpaEnseignantRepository jpaEnseignantRepository;
  private final TypeEnseignantFactory typeEnseignantFactory;
  private final PaysFactory paysFactory;

  public EnseignantFactory(JpaEnseignantRepository jpaEnseignantRepository,
      TypeEnseignantFactory typeEnseignantFactory, PaysFactory paysFactory) {
    this.jpaEnseignantRepository = jpaEnseignantRepository;
    this.typeEnseignantFactory = typeEnseignantFactory;
    this.paysFactory = paysFactory;
  }

  public EnseignantTable enseignant(){
    PaysTable pays = this.paysFactory.pays();
    TypeEnseignantTable typeEnseignantTable = this.typeEnseignantFactory.typeEnseignant1();
    var enseignant = new EnseignantTable();
    enseignant.setId(UUID.randomUUID());
    enseignant.setCivilite(Civilite.MONSIEUR);
    enseignant.setSpecialite("Mathematique");
    enseignant.setNom("Jamba");
    enseignant.setPrenoms("Thomer Jobert");
    enseignant.setContact("0214587");
    enseignant.setMatricule("0048 698");
    enseignant.setPiece(TypePiece.CNI);
    enseignant.setNumeroPiece("09 2563 558 09");
    enseignant.setNationnailite(pays);
    enseignant.setResidence("Yopougon");
    enseignant.setTypeEnseignant(typeEnseignantTable);
    return this.jpaEnseignantRepository.save(enseignant);
  }
}
