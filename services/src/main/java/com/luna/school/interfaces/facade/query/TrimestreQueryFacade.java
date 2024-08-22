package com.luna.school.interfaces.facade.query;


import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface TrimestreQueryFacade {
List<TrimestreEssentielVM> lister();
TrimestreDetailVM recupererParId(UUID id);
  List<TrimestreDetailVM> listerParAnneeScolaireId(UUID anneeScolaireId);

}
