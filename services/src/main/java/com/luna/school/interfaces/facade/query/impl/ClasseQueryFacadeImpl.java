package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.classe.application.vm.ClasseDetailVM;
import com.luna.school.classe.application.vm.ClasseEssentielVM;
import com.luna.school.interfaces.facade.query.ClasseQueryFacade;
import com.luna.school.query.classe.QueryClasseDetail;
import com.luna.school.query.classe.QueryListeClasse;
import com.luna.school.query.classe.QueryListeClasseParNiveau;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class ClasseQueryFacadeImpl implements ClasseQueryFacade {

  private final GestionnaireRequete<List<ClasseEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<List<ClasseDetailVM>, UUID> gestionnaireListerParNiveau;
  private final GestionnaireRequete<ClasseDetailVM, UUID> gestionnaireRecupereParId;

  public ClasseQueryFacadeImpl(QueryClasseDetail queryClasseDetail,
      QueryListeClasse queryListeClasse, QueryListeClasseParNiveau queryListeClasseParNiveau) {
    gestionnaireRecupereParId = queryClasseDetail;
    gestionnaireLister = queryListeClasse;
    gestionnaireListerParNiveau = queryListeClasseParNiveau;
  }

  @Override
  public List<ClasseEssentielVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public ClasseDetailVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }

  @Override
  public List<ClasseDetailVM> listerParNiveauId(UUID niveauId) {
    return this.gestionnaireListerParNiveau.requete(niveauId);
  }


}
