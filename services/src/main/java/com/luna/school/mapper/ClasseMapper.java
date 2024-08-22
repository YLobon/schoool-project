
package com.luna.school.mapper;


import com.luna.school.classe.application.vm.ClasseDetailVM;
import com.luna.school.classe.application.vm.ClasseEssentielVM;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.entite.ClasseTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class ClasseMapper {

  public static final ClasseMapper INSTANCE = Mappers.getMapper(ClasseMapper.class);

  public abstract Classe classeTableVersClasse(
      ClasseTable classeTable);

  public abstract ClasseTable classeVersClasseTable(
      Classe classe);

  public abstract ClasseEssentielVM classeTableVersClasseEssentielVM(
      ClasseTable classeTable);

  public abstract ClasseDetailVM classeTableVersClasseDetailVM(ClasseTable classeTable);

}
