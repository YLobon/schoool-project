package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.SousMatiereQueryFacade;
import com.luna.school.interfaces.facade.usecase.SousMatiereUseCaseFacade;
import com.luna.school.matiere.application.commande.CreerSousMatiereComande;
import com.luna.school.matiere.application.commande.ModifierSousMatierCommande;
import com.luna.school.matiere.application.vm.SousMatiereDetailVM;
import com.luna.school.matiere.application.vm.SousMatiereEssentielVM;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author BOUA YVES 2024-03-21
 */
@RestController
@RequestMapping("/api/luna/scolaire/sous-matiere")
public class SousMatiereRessource {

  private final SousMatiereUseCaseFacade sousMatiereUseCaseFacade;
  private final SousMatiereQueryFacade sousMatiereQueryFacade;

  public SousMatiereRessource(SousMatiereUseCaseFacade sousMatiereUseCaseFacade,
      SousMatiereQueryFacade sousMatiereQueryFacade) {
    this.sousMatiereUseCaseFacade = sousMatiereUseCaseFacade;
    this.sousMatiereQueryFacade = sousMatiereQueryFacade;
  }


  @GetMapping("/lister")
  public ResponseEntity<List<SousMatiereEssentielVM>> lister() {
    List<SousMatiereEssentielVM> lister = this.sousMatiereQueryFacade.lister();
    return ResponseEntity.ok(lister);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SousMatiereDetailVM> recupererParId(@PathVariable UUID id) {
    SousMatiereDetailVM sousMatiereDetailVM = this.sousMatiereQueryFacade.recupererParId(id);
    return ResponseEntity.ok(sousMatiereDetailVM);
  }

  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.sousMatiereUseCaseFacade.supprimer(id);
  }

  @PostMapping("/payer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerSousMatiereComande commande) {
    this.sousMatiereUseCaseFacade.creer(commande);
  }

  /**
   * <p>Méthode de modification d'une matiere.</p>
   *
   * @param commande commande modification d'une matiere.
   */
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierSousMatierCommande commande) {
    this.sousMatiereUseCaseFacade.modifier(commande);
  }

}
