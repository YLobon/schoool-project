package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.PermissionEtudiantQueryFacade;
import com.luna.school.permission.application.vm.PermissionEtudiantVM;
import com.luna.school.query.permission.QueryListePermissionEtudiant;
import com.luna.school.query.permission.QueryPermissionEtudiantDetail;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class PermissionEtudiantQueryFacadeImpl implements PermissionEtudiantQueryFacade {
 private final GestionnaireRequete<List<PermissionEtudiantVM>,Void> gestionnaireLister;
 private final GestionnaireRequete<PermissionEtudiantVM, UUID> gestionnaireRecupereParId;

  public PermissionEtudiantQueryFacadeImpl(
      QueryPermissionEtudiantDetail queryPermissionEtudiantDetail,
      QueryListePermissionEtudiant queryListePermissionEtudiant) {
    gestionnaireRecupereParId = queryPermissionEtudiantDetail;
    gestionnaireLister = queryListePermissionEtudiant;
  }

  @Override
  public List<PermissionEtudiantVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public PermissionEtudiantVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }
}
