package com.luna.school.interfaces.facade.query.impl;

import com.luna.school.interfaces.dto.NoteParMatiereVM;
import com.luna.school.interfaces.facade.query.NoteQueryFacade;
import com.luna.school.note.application.vm.NoteDetailVM;
import com.luna.school.note.application.vm.NoteEssentielVM;
import com.luna.school.query.note.QueryListeNote;
import com.luna.school.query.note.QueryListeNoteParMatiere;
import com.luna.school.query.note.QueryNoteDetail;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.tools.GestionnaireRequetePair;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-22 6:28 p.m..
 */
@Service
public class NoteQueryFacadeImpl implements NoteQueryFacade {

  private final GestionnaireRequete<List<NoteEssentielVM>, Void> gestionnaireLister;
  private final GestionnaireRequete<NoteDetailVM, UUID> gestionnaireRecupereParId;
  private final GestionnaireRequetePair<List<NoteEssentielVM>, UUID, UUID>
      gestionnaireRecupereParMatiereId;

  public NoteQueryFacadeImpl(QueryListeNote queryListeNote,
      QueryListeNoteParMatiere queryListeNoteParMatiere,
      QueryNoteDetail queryNoteDetail) {
    this.gestionnaireLister = queryListeNote;
    this.gestionnaireRecupereParId = queryNoteDetail;
    this.gestionnaireRecupereParMatiereId = queryListeNoteParMatiere;
  }

  @Override
  public List<NoteEssentielVM> lister() {
    return this.gestionnaireLister.requete(null);
  }

  @Override
  public NoteDetailVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }

  @Override
  public List<NoteEssentielVM> listerParMatiereIdClasse(UUID classeId, UUID matiereId) {
    return this.gestionnaireRecupereParMatiereId.requete(classeId, matiereId);
  }


  @Override
  public List<NoteParMatiereVM> listNoteParMatiereId(UUID classeId) {
    return List.of();
  }
}
