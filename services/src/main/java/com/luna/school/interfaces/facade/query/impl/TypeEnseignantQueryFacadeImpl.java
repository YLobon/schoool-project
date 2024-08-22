package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.TypeEnseignantQueryFacade;
import com.luna.school.query.typeenseignant.QueryListeTypeEnseignant;
import com.luna.school.query.typeenseignant.QueryTypeEnseignantDetail;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantDatailsVM;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantEssentielVM;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class TypeEnseignantQueryFacadeImpl implements TypeEnseignantQueryFacade {

  private final GestionnaireRequete<List<TypeEnseignantEssentielVM>, Void> gestionnaireListertypeEnseignant;
  private final GestionnaireRequete<TypeEnseignantDatailsVM, UUID> gestionnaireRecupereParId;

  public TypeEnseignantQueryFacadeImpl(QueryTypeEnseignantDetail queryTypeEnseignantDetail,
      QueryListeTypeEnseignant queryListeTypeEnseignant) {
    this.gestionnaireListertypeEnseignant = queryListeTypeEnseignant;
    this.gestionnaireRecupereParId = queryTypeEnseignantDetail;
  }

  @Override
  public List<TypeEnseignantEssentielVM> lister() {
    return this.gestionnaireListertypeEnseignant.requete(null);
  }

  @Override
  public TypeEnseignantDatailsVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }
}
