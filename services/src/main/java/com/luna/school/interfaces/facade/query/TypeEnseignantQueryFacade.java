package com.luna.school.interfaces.facade.query;


import com.luna.school.typeenseignant.application.vm.TypeEnseignantDatailsVM;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface TypeEnseignantQueryFacade {

  List<TypeEnseignantEssentielVM> lister();

  TypeEnseignantDatailsVM recupererParId(UUID id);
}
