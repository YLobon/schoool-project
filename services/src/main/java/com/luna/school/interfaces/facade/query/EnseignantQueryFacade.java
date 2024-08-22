package com.luna.school.interfaces.facade.query;


import com.luna.school.enseignant.application.vm.EnseignantDetailsVM;
import com.luna.school.enseignant.application.vm.EnseignantEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface EnseignantQueryFacade {
List<EnseignantEssentielVM> lister();
EnseignantDetailsVM recupererParId(UUID id);
}
