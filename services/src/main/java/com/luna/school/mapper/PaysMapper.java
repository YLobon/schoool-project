package com.luna.school.mapper;


import com.luna.school.entite.PaysTable;
import com.luna.school.pays.application.vm.PaysVM;
import com.luna.school.pays.domaine.entite.Pays;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES
 */
@Mapper
public abstract class PaysMapper {

    public static PaysMapper INSTANCE = Mappers.getMapper(PaysMapper.class);

    public abstract PaysTable paysVersPaysTable(Pays pays);

    public abstract Pays paysTableVersPays(PaysTable pays);

    public abstract PaysVM paysTableVersPaysVm(PaysTable pays);
}
