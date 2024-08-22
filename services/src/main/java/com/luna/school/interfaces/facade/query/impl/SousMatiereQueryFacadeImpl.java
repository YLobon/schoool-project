package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.SousMatiereQueryFacade;
import com.luna.school.matiere.application.vm.SousMatiereDetailVM;
import com.luna.school.matiere.application.vm.SousMatiereEssentielVM;
import com.luna.school.query.sousmatiere.QueryListeSousMatiere;
import com.luna.school.query.sousmatiere.QuerySousMatiereDetail;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class SousMatiereQueryFacadeImpl implements SousMatiereQueryFacade {

  private final GestionnaireRequete<List<SousMatiereEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<SousMatiereDetailVM, UUID> gestionnaireRecupereParId;

  public SousMatiereQueryFacadeImpl(
      QuerySousMatiereDetail querySousMatiereDetail, QueryListeSousMatiere queryListeSousMatiere) {
    this.gestionnaireLister = queryListeSousMatiere;
    this.gestionnaireRecupereParId = querySousMatiereDetail;
  }

  @Override
  public List<SousMatiereEssentielVM> lister() {
    return gestionnaireLister.requete(null);
  }

  @Override
  public SousMatiereDetailVM recupererParId(UUID id) {
    return gestionnaireRecupereParId.requete(id);
  }
}
