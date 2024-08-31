package com.luna.school.interfaces.rest;


import com.luna.school.enseignant.application.commande.CreerEnseignantCommande;
import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import com.luna.school.enseignant.application.vm.EnseignantDetailsVM;
import com.luna.school.enseignant.application.vm.EnseignantEssentielVM;
import com.luna.school.interfaces.facade.query.EnseignantQueryFacade;
import com.luna.school.interfaces.facade.usecase.EnseignantUseCaseFacade;
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
@RequestMapping("/api/luna/scolaire/enseignant")
public class EnseignantRessource {

  private final EnseignantQueryFacade enseignantQueryFacade;
  private final EnseignantUseCaseFacade enseignantUseCaseFacade;

  public EnseignantRessource(EnseignantQueryFacade enseignantQueryFacade,
      EnseignantUseCaseFacade enseignantUseCaseFacade) {
    this.enseignantQueryFacade = enseignantQueryFacade;
    this.enseignantUseCaseFacade = enseignantUseCaseFacade;
  }

  @Operation(summary = "lister les enseignants")
  @GetMapping("/lister")
  public ResponseEntity<List<EnseignantEssentielVM>> lister() {
    List<EnseignantEssentielVM> enseignantEssentielVMS = this.enseignantQueryFacade.lister();
    return ResponseEntity.ok(enseignantEssentielVMS);
  }

  @Operation(summary = "recuperer l'enseignant par id")
  @GetMapping("/{id}")
  public ResponseEntity<EnseignantDetailsVM> recupererParId(@PathVariable UUID id) {
    EnseignantDetailsVM enseignantDetailsVM = this.enseignantQueryFacade.recupererParId(id);
    return ResponseEntity.ok(enseignantDetailsVM);
  }

  @Operation(summary = "supprimer l'enseignant")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.enseignantUseCaseFacade.supprimer(id);
  }

  @Operation(summary = "creer enseignant")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerEnseignantCommande commande) {
    this.enseignantUseCaseFacade.creer(commande);
  }

  @Operation(summary = "modifier enseignant")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierEnseignantCommande commande) {
    this.enseignantUseCaseFacade.modifier(commande);
  }

}
