package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.MatiereQueryFacade;
import com.luna.school.interfaces.facade.usecase.MatiereUseCaseFacade;
import com.luna.school.matiere.application.commande.AssocierSousMatiereAuMatiereCommande;
import com.luna.school.matiere.application.commande.CreerMatiereCommande;
import com.luna.school.matiere.application.commande.ModifiereMatierCommande;
import com.luna.school.matiere.application.vm.MatiereDetailVM;
import com.luna.school.matiere.application.vm.MatiereEssentielVM;
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
@RequestMapping("/api/luna/scolaire/matiere")
public class MatiereRessource {

  private final MatiereUseCaseFacade matiereUseCaseFacade;
  private final MatiereQueryFacade matiereQueryFacade;

  public MatiereRessource(MatiereUseCaseFacade matiereUseCaseFacade,
      MatiereQueryFacade matiereQueryFacade) {
    this.matiereUseCaseFacade = matiereUseCaseFacade;
    this.matiereQueryFacade = matiereQueryFacade;
  }

  @Operation(summary = "lister les matieres")
  @GetMapping("/lister")
  public ResponseEntity<List<MatiereEssentielVM>> lister() {
    List<MatiereEssentielVM> essentielVMList = this.matiereQueryFacade.lister();
    return ResponseEntity.ok(essentielVMList);
  }

  @Operation(summary = "recuperer matiere par id")
  @GetMapping("/{id}")
  public ResponseEntity<MatiereDetailVM> recupererParId(@PathVariable UUID id) {
    MatiereDetailVM matiereDetailVM = this.matiereQueryFacade.recupererParId(id);
    return ResponseEntity.ok(matiereDetailVM);
  }

  @Operation(summary = "suprimer une matiere")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.matiereUseCaseFacade.supprimer(id);
  }

  @Operation(summary = "creer une matiere")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerMatiereCommande commande) {
    this.matiereUseCaseFacade.creer(commande);
  }

  @Operation(summary = "associer une sous matiere à la  matiere")
  @PostMapping("/ajouter")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody AssocierSousMatiereAuMatiereCommande commande) {
    this.matiereUseCaseFacade.ajouterSousMatiereAuxMatiere(commande);
  }

  /**
   * <p>Méthode de modification d'une matiere.</p>
   *
   * @param commande commande modification d'une matiere.
   */
  @Operation(summary = "modifier une matiere")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifiereMatierCommande commande) {
    this.matiereUseCaseFacade.modifier(commande);
  }

}
