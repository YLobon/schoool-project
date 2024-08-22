package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.TrimestreQueryFacade;
import com.luna.school.query.trimestre.QueryListeTrimestre;
import com.luna.school.query.trimestre.QueryListeTrimestreParAnnerScolaire;
import com.luna.school.query.trimestre.QueryTrimestreDetail;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class TrimestreQueryFacadeImpl implements TrimestreQueryFacade {

  private final GestionnaireRequete<List<TrimestreEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<List<TrimestreDetailVM>, UUID> gestionnaireListerParAnneeScolaire;
  private final GestionnaireRequete<TrimestreDetailVM, UUID> gestionnaireRecupereParId;

  public TrimestreQueryFacadeImpl(QueryTrimestreDetail queryTrimestreDetail,
      QueryListeTrimestre queryListeTrimestre,
      QueryListeTrimestreParAnnerScolaire queryListeTrimestreParAnnerScolaire) {
    gestionnaireRecupereParId = queryTrimestreDetail;
    gestionnaireLister = queryListeTrimestre;
    gestionnaireListerParAnneeScolaire = queryListeTrimestreParAnnerScolaire;
  }

  @Override
  public List<TrimestreEssentielVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public TrimestreDetailVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }

  @Override
  public List<TrimestreDetailVM> listerParAnneeScolaireId(UUID anneeScolaireId) {
    return this.gestionnaireListerParAnneeScolaire.requete(anneeScolaireId);
  }


}
