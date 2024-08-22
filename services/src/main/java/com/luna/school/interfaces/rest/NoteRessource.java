package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.dto.NoteParMatiereVM;
import com.luna.school.interfaces.facade.query.NoteQueryFacade;
import com.luna.school.interfaces.facade.usecase.NoteUseCaseFacade;
import com.luna.school.note.application.commande.CreerNoteCommande;
import com.luna.school.note.application.vm.NoteDetailVM;
import com.luna.school.note.application.vm.NoteEssentielVM;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author BOUA YVES 2024-03-21
 */
@RestController
@RequestMapping("/api/luna/scolaire/note")
public class NoteRessource {
private final NoteUseCaseFacade noteUseCaseFacade;
private final NoteQueryFacade noteQueryFacade;

  public NoteRessource(NoteUseCaseFacade noteUseCaseFacade, NoteQueryFacade noteQueryFacade) {
    this.noteUseCaseFacade = noteUseCaseFacade;
    this.noteQueryFacade = noteQueryFacade;
  }

  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerNoteCommande commande) {
    this.noteUseCaseFacade.creer(commande);
  }
  @GetMapping("/lister")
  public ResponseEntity<List<NoteEssentielVM>> lister() {
    List<NoteEssentielVM> lister = this.noteQueryFacade.lister();
    return ResponseEntity.ok(lister);
  }

  @GetMapping("/classe/{classeId}/matiere/{matiereId}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<NoteEssentielVM>> listerParMatiere(
      @PathVariable("classeId") UUID classeId,
      @PathVariable("matiereId") UUID matiereId) {

    List<NoteEssentielVM> noteEssentielVMList = this.noteQueryFacade.listerParMatiereIdClasse(classeId, matiereId);
    return new ResponseEntity<>(noteEssentielVMList, HttpStatus.OK);
  }


  @GetMapping("/{id}")
  public ResponseEntity<NoteDetailVM> recupererParId(@PathVariable UUID id) {

    NoteDetailVM noteDetailVM = this.noteQueryFacade.recupererParId(id);
    return ResponseEntity.ok(noteDetailVM);
  }

  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.noteUseCaseFacade.supprimer(id);
  }

  @GetMapping("/{classeId}/classe")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<NoteParMatiereVM>> listerParClasse(
      @PathVariable("classeId") UUID classeId) {
    List<NoteParMatiereVM> noteParMatiereVMS = this.noteQueryFacade.listNoteParMatiereId(classeId);
    return new ResponseEntity<>(noteParMatiereVMS, HttpStatus.OK);
  }

}
