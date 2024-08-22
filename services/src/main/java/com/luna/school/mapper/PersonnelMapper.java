
package com.luna.school.mapper;


import com.luna.school.entite.PersonnelTable;
import com.luna.school.personnel.application.vm.PersonnelDetailVM;
import com.luna.school.personnel.application.vm.PersonnelEssentielVM;
import com.luna.school.personnel.domaine.entite.Personnel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class PersonnelMapper {

  public static final PersonnelMapper INSTANCE = Mappers.getMapper(PersonnelMapper.class);

  public abstract Personnel personnelTableVersPersonnel(
      PersonnelTable personnelTable);

  public abstract PersonnelTable personnelVersPersonnelTable(
      Personnel personnel);

  public abstract PersonnelDetailVM personnelTableVersPersonnelDetailVM(
      PersonnelTable personnelTable);

  public abstract PersonnelEssentielVM personnelTableVersPersonnelEssentielVM(
      PersonnelTable personnelTable);

}
