package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.comptabilite.application.vm.ScolariteDetailsVM;
import com.luna.school.comptabilite.application.vm.ScolariteEssentielVM;
import com.luna.school.interfaces.facade.query.ScolariteQueryFacade;
import com.luna.school.query.scolarite.QueryListeScolarite;
import com.luna.school.query.scolarite.QueryListeScolariteParEtudiant;
import com.luna.school.query.scolarite.QueryScolariteDetail;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class ScolariteQueryFacadeImpl implements ScolariteQueryFacade {


  private final GestionnaireRequete<List<ScolariteEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<List<ScolariteDetailsVM>, UUID> gestionnaireListerParEtudiant;
  private final GestionnaireRequete<ScolariteDetailsVM, UUID> gestionnaireRecupereParId;

  public ScolariteQueryFacadeImpl(QueryScolariteDetail queryScolariteDetail,
      QueryListeScolarite queryListeScolarite,
      QueryListeScolariteParEtudiant queryListeScolariteParEtudiant) {
    gestionnaireRecupereParId = queryScolariteDetail;
    gestionnaireLister = queryListeScolarite;
    gestionnaireListerParEtudiant = queryListeScolariteParEtudiant;
  }


  @Override
  public List<ScolariteEssentielVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public ScolariteDetailsVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }

  @Override
  public List<ScolariteDetailsVM> listerParEtudiantId(UUID etudiantId) {
    return this.gestionnaireListerParEtudiant.requete(etudiantId);
  }
}
