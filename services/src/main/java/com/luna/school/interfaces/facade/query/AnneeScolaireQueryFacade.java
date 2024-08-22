package com.luna.school.interfaces.facade.query;


import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface AnneeScolaireQueryFacade {
List<AnneeScolaireEssentielVM> lister();
AnneeScolaireDatailsVM recupererParId(UUID id);
}
