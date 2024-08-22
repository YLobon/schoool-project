package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.enseignant.application.vm.EnseignantDetailsVM;
import com.luna.school.enseignant.application.vm.EnseignantEssentielVM;
import com.luna.school.interfaces.facade.query.EnseignantQueryFacade;
import com.luna.school.query.enseignant.QueryEnseignantDetail;
import com.luna.school.query.enseignant.QueryListeEnseignant;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class EnseignantQueryFacadeImpl implements EnseignantQueryFacade {

  private final GestionnaireRequete<List<EnseignantEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<EnseignantDetailsVM, UUID> gestionnaireRecupereParId;

  public EnseignantQueryFacadeImpl(QueryEnseignantDetail queryEnseignantDetail,
      QueryListeEnseignant queryListeEnseignant) {
    gestionnaireRecupereParId = queryEnseignantDetail;
    gestionnaireLister = queryListeEnseignant;
  }

  @Override
  public List<EnseignantEssentielVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public EnseignantDetailsVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }
}
