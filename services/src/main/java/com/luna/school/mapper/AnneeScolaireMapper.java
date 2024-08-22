package com.luna.school.mapper;


import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.entite.AnneeScolaireTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class AnneeScolaireMapper {

  public static final AnneeScolaireMapper INSTANCE = Mappers.getMapper(AnneeScolaireMapper.class);

  public abstract AnneeScolaire anneeScolaireTableVersAnneeScolaire(
      AnneeScolaireTable anneeScolaireTable);

  public abstract AnneeScolaireTable anneeScolaireVersAnneeScolaireTable(
      AnneeScolaire anneeScolaire);

  public abstract AnneeScolaireEssentielVM anneeScolaireTAbleVersAnneeScolaireEssentielVM(
      AnneeScolaireTable anneeScolaireTable);

  public abstract AnneeScolaireDatailsVM anneeScolaireTAbleVersAnneeScolaireDatailsVM(
      AnneeScolaireTable appreciationTable);


}
