
package com.luna.school.mapper;


import com.luna.school.entite.SerieTable;
import com.luna.school.serie.application.vm.SerieVM;
import com.luna.school.serie.domaine.entite.Serie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class SerieMapper {

  public static final SerieMapper INSTANCE = Mappers.getMapper(SerieMapper.class);

  public abstract Serie serieTableVersSerie(
      SerieTable serieTable);

  public abstract SerieTable serieVersSerieTable(
      Serie serie);

  public abstract SerieVM serieTableVersSerieVM(
      SerieTable serieTable);

}
