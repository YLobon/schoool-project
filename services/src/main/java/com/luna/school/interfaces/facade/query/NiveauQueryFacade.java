package com.luna.school.interfaces.facade.query;


import com.luna.school.niveau.application.vm.NiveauDetailsVM;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface NiveauQueryFacade {
List<NiveauEssentielVM> lister();
NiveauDetailsVM recupererParId(UUID id);
}
