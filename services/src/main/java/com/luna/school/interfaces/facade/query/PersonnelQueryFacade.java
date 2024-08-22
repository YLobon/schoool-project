package com.luna.school.interfaces.facade.query;


import com.luna.school.personnel.application.vm.PersonnelDetailVM;
import com.luna.school.personnel.application.vm.PersonnelEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface PersonnelQueryFacade {

  List<PersonnelEssentielVM> lister();

  PersonnelDetailVM recupererParId(UUID id);
}
