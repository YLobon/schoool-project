package com.luna.school.interfaces.facade.query.impl;

import com.luna.school.enumeration.Civilite;
import com.luna.school.etudiant.application.vm.EtudiantDetailVM;
import com.luna.school.etudiant.application.vm.EtudiantEssentielVM;
import com.luna.school.etudiant.application.vm.StatistiqueVM;
import com.luna.school.interfaces.facade.query.EtudiantQueryFacade;
import com.luna.school.query.etudiant.QueryEtudiantDetail;
import com.luna.school.query.etudiant.QueryListeEtudiant;
import com.luna.school.query.etudiant.QueryListeEtudiantParSexe;
import com.luna.school.query.etudiant.QueryStatistiqueVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-17 11:02 a.m..
 */
@Service
public class EtudiantQueryFacadeImpl implements EtudiantQueryFacade {

  private final GestionnaireRequete<List<EtudiantEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<List<EtudiantDetailVM>, Civilite> gestionnaireListerParSexe;
  private final GestionnaireRequete<EtudiantDetailVM, UUID> gestionnaireRecupereParId;
  private final GestionnaireRequete<StatistiqueVM, Void> statistique;

  public EtudiantQueryFacadeImpl(QueryListeEtudiant queryListeEtudiant,
      QueryEtudiantDetail queryEtudiantDetail, QueryListeEtudiantParSexe queryListeEtudiantParSexe,
      QueryStatistiqueVM queryStatistiqueVM) {
    this.gestionnaireLister = queryListeEtudiant;
    this.gestionnaireListerParSexe = queryListeEtudiantParSexe;
    this.gestionnaireRecupereParId = queryEtudiantDetail;
    this.statistique = queryStatistiqueVM;
  }


  @Override
  public List<EtudiantEssentielVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public EtudiantDetailVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }

  @Override
  public List<EtudiantDetailVM> listerParSexe(Civilite civilite) {
    return this.gestionnaireListerParSexe.requete(civilite);
  }

  @Override
  public StatistiqueVM statistique() {
    return this.statistique.requete(null);
  }
}
