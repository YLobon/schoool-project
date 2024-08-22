
package com.luna.school.mapper;


import com.luna.school.entite.SousMatiereTable;
import com.luna.school.matiere.application.vm.SousMatiereDetailVM;
import com.luna.school.matiere.application.vm.SousMatiereEssentielVM;
import com.luna.school.matiere.domaine.entite.SousMatiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class SousMatiereMapper {

  public static final SousMatiereMapper INSTANCE = Mappers.getMapper(SousMatiereMapper.class);

  public abstract SousMatiere sousMatiereTableVersSousMatiere(
      SousMatiereTable sousMatiereTable);

  public abstract SousMatiereTable sousMatiereVersSousMatiereTable(
      SousMatiere sousMatiere);

  public abstract SousMatiereDetailVM sousMatiereTableVersSousMatiereDetailVM(
      SousMatiereTable sousMatiereTable);

  public abstract SousMatiereEssentielVM sousMatiereTableVersSousMatiereEssentielVM(
      SousMatiereTable sousMatiereTable);

}
