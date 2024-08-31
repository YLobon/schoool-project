package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.TrimestreQueryFacade;
import com.luna.school.interfaces.facade.usecase.TrimestreUseCaseFacade;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
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
@RequestMapping("/api/luna/scolaire/trimestre")
public class TrimestreRessource {

  private final TrimestreUseCaseFacade trimestreUseCaseFacade;
  private final TrimestreQueryFacade trimestreQueryFacade;

  public TrimestreRessource(TrimestreUseCaseFacade trimestreUseCaseFacade,
      TrimestreQueryFacade trimestreQueryFacade) {
    this.trimestreUseCaseFacade = trimestreUseCaseFacade;
    this.trimestreQueryFacade = trimestreQueryFacade;
  }

  @Operation(summary = "Lister les trimestres")
  @GetMapping("/lister")
  public ResponseEntity<List<TrimestreEssentielVM>> lister() {
    List<TrimestreEssentielVM> trimestreEssentielVMS = this.trimestreQueryFacade.lister();
    return ResponseEntity.ok(trimestreEssentielVMS);
  }

  @Operation(summary = "Lister les Trimestre par années scolaire")
  @GetMapping("/{anneeScolaireId}/annee-scolaire")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<TrimestreDetailVM>> listerParAnneeScolaire(
      @PathVariable("anneeScolaireId") UUID anneeScolaireId) {
    List<TrimestreDetailVM> actionVms = this.trimestreQueryFacade.listerParAnneeScolaireId(
        anneeScolaireId);
    return new ResponseEntity<>(actionVms, HttpStatus.OK);
  }

  @Operation(summary = "Recuperer trimestre par id")
  @GetMapping("/{id}")
  public ResponseEntity<TrimestreDetailVM> recupererParId(@PathVariable UUID id) {
    TrimestreDetailVM trimestreDetailVM =
        this.trimestreQueryFacade.recupererParId(id);
    return ResponseEntity.ok(trimestreDetailVM);
  }

  @Operation(summary = "Supprimer un trimestre")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.trimestreUseCaseFacade.supprimer(id);
  }

  @Operation(summary = "Creer un trimestre")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerTrimestreCommande commande) {
    this.trimestreUseCaseFacade.creer(commande);
  }

  @Operation(summary = "modifier un trimestre")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierTrimestreCommande commande) {
    this.trimestreUseCaseFacade.modifier(commande);
  }

}
