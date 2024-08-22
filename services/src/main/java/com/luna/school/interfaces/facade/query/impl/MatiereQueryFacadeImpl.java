package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.MatiereQueryFacade;
import com.luna.school.matiere.application.vm.MatiereDetailVM;
import com.luna.school.matiere.application.vm.MatiereEssentielVM;
import com.luna.school.query.matiere.QueryListeMatiere;
import com.luna.school.query.matiere.QueryMatiereDetail;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class MatiereQueryFacadeImpl implements MatiereQueryFacade {

  private final GestionnaireRequete<List<MatiereEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<MatiereDetailVM, UUID> gestionnaireRecupereParId;

  public MatiereQueryFacadeImpl(
      QueryMatiereDetail queryMatiereDetail, QueryListeMatiere queryListeMatiere) {
    this.gestionnaireLister = queryListeMatiere;
    this.gestionnaireRecupereParId = queryMatiereDetail;
  }


  @Override
  public List<MatiereEssentielVM> lister() {
    return gestionnaireLister.requete(null);
  }

  @Override
  public MatiereDetailVM recupererParId(UUID id) {
    return gestionnaireRecupereParId.requete(id);
  }
}
