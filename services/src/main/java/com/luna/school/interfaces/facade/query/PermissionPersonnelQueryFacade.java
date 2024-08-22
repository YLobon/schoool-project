package com.luna.school.interfaces.facade.query;


import com.luna.school.permission.application.vm.PermissionPersonnelVM;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-18
 */
public interface PermissionPersonnelQueryFacade {

  List<PermissionPersonnelVM> lister();

  PermissionPersonnelVM recupererParId(UUID id);
}
