package com.luna.school.factory;


import com.luna.school.entite.MatiereTable;
import com.luna.school.entite.SousMatiereTable;
import com.luna.school.repository.JpaMatiereRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class MatiereFactory {

  private final JpaMatiereRepository jpaMatiereRepository;
  private final SousMatiereFactory sousMatiereFactory;

  public MatiereFactory(JpaMatiereRepository jpaMatiereRepository,
      SousMatiereFactory sousMatiereFactory) {
    this.jpaMatiereRepository = jpaMatiereRepository;
    this.sousMatiereFactory = sousMatiereFactory;
  }

  public MatiereTable matiere() {
    var matiere = new MatiereTable();
    matiere.setId(UUID.randomUUID());
    matiere.setNom("Mathematique");
    matiere.setCoefficient(4);
    matiere.setSousMatiere(false);
    return this.jpaMatiereRepository.save(matiere);
  }

  public MatiereTable matiereTable() {
    var matiere = new MatiereTable();
    matiere.setId(UUID.randomUUID());
    matiere.setNom("Histoire geographie");
    matiere.setCoefficient(2);
    matiere.setSousMatiere(false);
    return this.jpaMatiereRepository.save(matiere);
  }

  public MatiereTable matiereFrancais() {
    SousMatiereTable sousMatiereTable = this.sousMatiereFactory.sousMatiere();
    SousMatiereTable sousMatiereTable1 = this.sousMatiereFactory.sousMatiere2();
    SousMatiereTable sousMatiereTable2 = this.sousMatiereFactory.sousMatiere3();
    var matiere = new MatiereTable();
    matiere.setId(UUID.randomUUID());
    matiere.setNom("Francais");
    matiere.setCoefficient(2);
    matiere.setSousMatiere(true);
    matiere.setSousMatieres(List.of(sousMatiereTable,sousMatiereTable1,sousMatiereTable2));
    return this.jpaMatiereRepository.save(matiere);
  }


}
