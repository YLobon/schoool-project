package com.luna.school.interfaces.rest;


import com.luna.school.comptabilite.application.commande.PayerScolariteCommande;
import com.luna.school.comptabilite.application.vm.ScolariteDetailsVM;
import com.luna.school.comptabilite.application.vm.ScolariteEssentielVM;
import com.luna.school.interfaces.facade.query.ScolariteQueryFacade;
import com.luna.school.interfaces.facade.usecase.ScolariteUseCaseFacade;
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
@RequestMapping("/api/luna/scolaire/scolarite")
public class ScolariteRessource {
private final ScolariteUseCaseFacade scolariteUseCaseFacade;
private final ScolariteQueryFacade scolariteQueryFacade;

  public ScolariteRessource(ScolariteUseCaseFacade scolariteUseCaseFacade,
      ScolariteQueryFacade scolariteQueryFacade) {
    this.scolariteUseCaseFacade = scolariteUseCaseFacade;
    this.scolariteQueryFacade = scolariteQueryFacade;
  }

  @GetMapping("/lister")
  public ResponseEntity<List<ScolariteEssentielVM>> lister() {
    List<ScolariteEssentielVM> lister = this.scolariteQueryFacade.lister();
    return ResponseEntity.ok(lister);
  }

  @GetMapping("/{etudiantId}/scolarite")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ScolariteDetailsVM>> listerParEtudiant(
      @PathVariable("etudiantId") UUID etudiantId) {
    List<ScolariteDetailsVM> scolariteDetailsVMS = this.scolariteQueryFacade
        .listerParEtudiantId(etudiantId);
    return new ResponseEntity<>(scolariteDetailsVMS, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ScolariteDetailsVM> recupererParId(@PathVariable UUID id) {
    ScolariteDetailsVM scolariteDetailsVM = this.scolariteQueryFacade.recupererParId(id);
    return ResponseEntity.ok(scolariteDetailsVM);
  }

  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.scolariteUseCaseFacade.supprimer(id);
  }

  @PostMapping("/payer-scolarite")
  @ResponseStatus(HttpStatus.CREATED)
  public void payer(@Valid @RequestBody PayerScolariteCommande commande) {
    this.scolariteUseCaseFacade.payer(commande);
  }

}
