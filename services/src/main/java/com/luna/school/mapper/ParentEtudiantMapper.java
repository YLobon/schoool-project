
package com.luna.school.mapper;


import com.luna.school.entite.ParentEtudiantTable;
import com.luna.school.etudiant.application.vm.ParentEtudiantDetailVM;
import com.luna.school.etudiant.application.vm.ParentEtudiantEssentielVM;
import com.luna.school.etudiant.domaine.entite.ParentEtudiant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class ParentEtudiantMapper {

  public static final ParentEtudiantMapper INSTANCE = Mappers.getMapper(ParentEtudiantMapper.class);

  public abstract ParentEtudiant parentEtudiantTableVersParentEtudiant(
      ParentEtudiantTable parentEtudiantTable);

  public abstract ParentEtudiantTable parentEtudiantVersParentEtudiantTable(
      ParentEtudiant parentEtudiant);

  public abstract ParentEtudiantEssentielVM parentEtudiantTableVersParentEtudiantEssentielVM(
      ParentEtudiantTable parentEtudiantTable);

  public abstract ParentEtudiantDetailVM parentEtudiantTableVersParentEtudiantDetailVM(ParentEtudiantTable parentEtudiantTable);

}
