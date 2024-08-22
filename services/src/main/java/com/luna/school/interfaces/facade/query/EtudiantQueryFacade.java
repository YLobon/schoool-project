package com.luna.school.interfaces.facade.query;


import com.luna.school.enumeration.Civilite;
import com.luna.school.etudiant.application.vm.EtudiantDetailVM;
import com.luna.school.etudiant.application.vm.EtudiantEssentielVM;
import com.luna.school.etudiant.application.vm.StatistiqueVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface EtudiantQueryFacade {

  List<EtudiantEssentielVM> lister();

  EtudiantDetailVM recupererParId(UUID id);

  List<EtudiantDetailVM> listerParSexe(Civilite civilite);

  StatistiqueVM statistique();

}
