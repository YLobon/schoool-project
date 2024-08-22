package com.luna.school.interfaces.facade.query;


import com.luna.school.comptabilite.application.vm.ScolariteDetailsVM;
import com.luna.school.comptabilite.application.vm.ScolariteEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface ScolariteQueryFacade {

  List<ScolariteEssentielVM> lister();

  ScolariteDetailsVM recupererParId(UUID id);

  List<ScolariteDetailsVM> listerParEtudiantId(UUID etudiantId);

}
