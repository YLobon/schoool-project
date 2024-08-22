package com.luna.school.interfaces.facade.query;


import com.luna.school.serie.application.vm.SerieVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface SerieQueryFacade {
List<SerieVM> lister();
  SerieVM recupererParId(UUID id);
}
