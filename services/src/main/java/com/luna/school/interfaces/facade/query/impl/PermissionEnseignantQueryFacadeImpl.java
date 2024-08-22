package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.PermissionEnseignantQueryFacade;
import com.luna.school.permission.application.vm.PermissionEnseignantVM;
import com.luna.school.query.permission.QueryListePermissionEnseignant;
import com.luna.school.query.permission.QueryPermissionEnseignantDetail;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class PermissionEnseignantQueryFacadeImpl implements PermissionEnseignantQueryFacade {

  private final GestionnaireRequete<List<PermissionEnseignantVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<PermissionEnseignantVM, UUID> gestionnaireRecupereParId;

  public PermissionEnseignantQueryFacadeImpl(
      QueryPermissionEnseignantDetail queryPermissionEnseignantDetail,
      QueryListePermissionEnseignant queryListePermissionEnseignant) {
    gestionnaireRecupereParId = queryPermissionEnseignantDetail;
    gestionnaireLister = queryListePermissionEnseignant;
  }

  @Override
  public List<PermissionEnseignantVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public PermissionEnseignantVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }
}
