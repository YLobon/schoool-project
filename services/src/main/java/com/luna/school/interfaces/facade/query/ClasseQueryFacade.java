package com.luna.school.interfaces.facade.query;


import com.luna.school.classe.application.vm.ClasseDetailVM;
import com.luna.school.classe.application.vm.ClasseEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface ClasseQueryFacade {
List<ClasseEssentielVM> lister();
ClasseDetailVM recupererParId(UUID id);
  List<ClasseDetailVM> listerParNiveauId(UUID niveauId);

}
