package com.luna.school.interfaces.facade.query.impl;


import com.luna.school.interfaces.facade.query.PersonnelQueryFacade;
import com.luna.school.personnel.application.vm.PersonnelDetailVM;
import com.luna.school.personnel.application.vm.PersonnelEssentielVM;
import com.luna.school.query.personnel.QueryListePersonnel;
import com.luna.school.query.personnel.QueryPersonnelDetail;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class PersonnelQueryFacadeImpl implements PersonnelQueryFacade {

  private final GestionnaireRequete<List<PersonnelEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<PersonnelDetailVM, UUID> gestionnaireRecupereParId;

  public PersonnelQueryFacadeImpl(QueryPersonnelDetail queryPersonnelDetail,
      QueryListePersonnel queryListePersonnel) {
    this.gestionnaireLister = queryListePersonnel;
    this.gestionnaireRecupereParId = queryPersonnelDetail;
  }

  @Override
  public List<PersonnelEssentielVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public PersonnelDetailVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }


}
