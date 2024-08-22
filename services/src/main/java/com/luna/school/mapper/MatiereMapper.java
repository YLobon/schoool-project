
package com.luna.school.mapper;


import com.luna.school.entite.MatiereTable;
import com.luna.school.matiere.application.vm.MatiereDetailVM;
import com.luna.school.matiere.application.vm.MatiereEssentielVM;
import com.luna.school.matiere.domaine.entite.Matiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class MatiereMapper {

  public static final MatiereMapper INSTANCE = Mappers.getMapper(MatiereMapper.class);

  public abstract Matiere matiereTableeVersMatiere(
      MatiereTable matiereTable);

  public abstract MatiereTable matiereVersMatiereTable(
      Matiere matiere);

  public abstract MatiereDetailVM matiereTableVersMatiereDetailVM(
      MatiereTable matiereTable);

  public abstract MatiereEssentielVM matiereTableVersMatiereEssentielVM(
      MatiereTable matiereTable);

}
