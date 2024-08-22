package com.luna.school.interfaces.facade.query.impl;

import com.luna.school.interfaces.facade.query.NiveauQueryFacade;
import com.luna.school.niveau.application.vm.NiveauDetailsVM;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import com.luna.school.query.niveau.QueryListeNiveau;
import com.luna.school.query.niveau.QueryNiveauDetail;
import com.luna.school.repository.JpaNiveauRepository;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-31 6:22 p.m..
 */
@Service
public class NiveauQueryFacadeImpl implements NiveauQueryFacade {
private final GestionnaireRequete<List<NiveauEssentielVM>, Void> gestionnaireListe;
private final GestionnaireRequete<NiveauDetailsVM, UUID> gestionnaireRecuperer;

  public NiveauQueryFacadeImpl(JpaNiveauRepository jpaNiveauRepository) {
    this.gestionnaireListe = new QueryListeNiveau(jpaNiveauRepository);
    this.gestionnaireRecuperer = new QueryNiveauDetail(jpaNiveauRepository);
  }

  @Override
  public List<NiveauEssentielVM> lister() {
    return this.gestionnaireListe.requete(null);
  }

  @Override
  public NiveauDetailsVM recupererParId(UUID id) {
    return this.gestionnaireRecuperer.requete(id);
  }
}
