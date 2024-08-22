
package com.luna.school.mapper;


import com.luna.school.entite.EtudiantTable;
import com.luna.school.etudiant.application.vm.EtudiantDetailVM;
import com.luna.school.etudiant.application.vm.EtudiantEssentielVM;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class EtudiantMapper {

  public static final EtudiantMapper INSTANCE = Mappers.getMapper(EtudiantMapper.class);

  public abstract Etudiant etudiantTableVersEtudiant(
      EtudiantTable etudiantTable);

  public abstract EtudiantTable etudiantVersEtudiantTable(
      Etudiant etudiant);

  public abstract EtudiantDetailVM etudiantTableVersEtudiantDetailVM(
      EtudiantTable etudiantTable);

  public abstract EtudiantEssentielVM etudiantTableVersEtudiantEssentielVM(
      EtudiantTable etudiantTable);

}
