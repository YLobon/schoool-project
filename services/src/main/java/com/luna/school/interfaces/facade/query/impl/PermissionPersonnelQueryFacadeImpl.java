package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.PermissionPersonnelQueryFacade;
import com.luna.school.permission.application.vm.PermissionPersonnelVM;
import com.luna.school.query.permission.QueryListePermissionPersonnel;
import com.luna.school.query.permission.QueryPermissionPersonnelDetail;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class PermissionPersonnelQueryFacadeImpl implements PermissionPersonnelQueryFacade {
 private final GestionnaireRequete<List<PermissionPersonnelVM>,Void> gestionnaireLister;
 private final GestionnaireRequete<PermissionPersonnelVM, UUID> gestionnaireRecupereParId;

  public PermissionPersonnelQueryFacadeImpl(QueryPermissionPersonnelDetail queryPermissionPersonnelDetail,
      QueryListePermissionPersonnel queryListePermissionPersonnel) {
    gestionnaireRecupereParId = queryPermissionPersonnelDetail;
    gestionnaireLister = queryListePermissionPersonnel;
  }

  @Override
  public List<PermissionPersonnelVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public PermissionPersonnelVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }
}
