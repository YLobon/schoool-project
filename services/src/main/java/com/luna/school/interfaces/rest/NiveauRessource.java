package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.NiveauQueryFacade;
import com.luna.school.interfaces.facade.usecase.NiveauCaseFacade;
import com.luna.school.niveau.application.commande.CreerNiveauCommande;
import com.luna.school.niveau.application.commande.ModifierNiveauCommande;
import com.luna.school.niveau.application.vm.NiveauDetailsVM;
import com.luna.school.niveau.application.vm.NiveauEssentielVM;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/luna/scolaire/niveau")
public class NiveauRessource {

  private final NiveauCaseFacade niveauCaseFacade;
  private final NiveauQueryFacade niveauQueryFacade;

  public NiveauRessource(NiveauCaseFacade niveauCaseFacade, NiveauQueryFacade niveauQueryFacade) {
    this.niveauCaseFacade = niveauCaseFacade;
    this.niveauQueryFacade = niveauQueryFacade;
  }

  @Operation(summary = "lister les niveau")
  @GetMapping("/lister")
  public ResponseEntity<List<NiveauEssentielVM>> lister() {
    List<NiveauEssentielVM> niveauEssentielVM = this.niveauQueryFacade.lister();
    return ResponseEntity.ok(niveauEssentielVM);
  }

  @Operation(summary = "recuperer le niveau par id")
  @GetMapping("/{id}")
  public ResponseEntity<NiveauDetailsVM> recupererParId(@PathVariable UUID id) {
    NiveauDetailsVM niveauDetailsVM = this.niveauQueryFacade.recupererParId(id);
    return ResponseEntity.ok(niveauDetailsVM);
  }

  @Operation(summary = "supprimer le niveau")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.niveauCaseFacade.supprimer(id);
  }

  @Operation(summary = "creer niveau")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerNiveauCommande commande) {
    this.niveauCaseFacade.creer(commande);
  }

  @Operation(summary = "modifier le niveau")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierNiveauCommande commande) {
    this.niveauCaseFacade.modifier(commande);
  }

}
