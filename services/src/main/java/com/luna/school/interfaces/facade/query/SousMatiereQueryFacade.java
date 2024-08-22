package com.luna.school.interfaces.facade.query;


import com.luna.school.matiere.application.vm.SousMatiereDetailVM;
import com.luna.school.matiere.application.vm.SousMatiereEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface SousMatiereQueryFacade {

  List<SousMatiereEssentielVM> lister();

  SousMatiereDetailVM recupererParId(UUID id);
}
