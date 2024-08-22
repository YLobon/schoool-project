
package com.luna.school.mapper;


import com.luna.school.entite.InscriptionTable;
import com.luna.school.inscription.application.vm.InscriptionDetailVM;
import com.luna.school.inscription.application.vm.InscriptionEssentielVM;
import com.luna.school.inscription.domaine.entite.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class InscriptionMapper {

  public static final InscriptionMapper INSTANCE = Mappers.getMapper(InscriptionMapper.class);

  public abstract Inscription inscriptionTableVersInscription(
      InscriptionTable inscriptionTable);

  public abstract InscriptionTable inscriptionVersInscriptionTable(
      Inscription inscription);

  public abstract InscriptionDetailVM inscriptionTableVersInscriptionDetailVM(
      InscriptionTable inscriptionTable);

  public abstract InscriptionEssentielVM inscriptionTableVersInscriptionEssentielVM(
      InscriptionTable inscriptionTable);

}
