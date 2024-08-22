
package com.luna.school.mapper;


import com.luna.school.entite.EtudiantTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.etudiant.application.vm.StatistiqueVM;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class StatistiqueMapper {

  public static final StatistiqueMapper INSTANCE = Mappers.getMapper(StatistiqueMapper.class);


  public StatistiqueVM etudiantTableVersStatistiqueVM(List<EtudiantTable> etudiants) {
    StatistiqueVM statistiqueVM = new StatistiqueVM();

    int nombreTotalEtudiant = etudiants.size();

    int nombreEtudiantMasculin = (int) etudiants.stream()
        .filter(e -> e.getCivilite() == Civilite.MONSIEUR)
        .count();

    int nombreEtudiantFeminin = (int) etudiants.stream()
        .filter(e -> e.getCivilite() == Civilite.MADAME)
        .count();

    statistiqueVM.setNombreTotalEtudiant(nombreTotalEtudiant);
    statistiqueVM.setNombreEtudiantMasculin(nombreEtudiantMasculin);
    statistiqueVM.setNombreEtudiantFeminin(nombreEtudiantFeminin);

    return statistiqueVM;
  }

}
