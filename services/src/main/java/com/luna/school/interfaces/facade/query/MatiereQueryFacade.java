package com.luna.school.interfaces.facade.query;


import com.luna.school.matiere.application.vm.MatiereDetailVM;
import com.luna.school.matiere.application.vm.MatiereEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface MatiereQueryFacade {

  List<MatiereEssentielVM> lister();

  MatiereDetailVM recupererParId(UUID id);
}
