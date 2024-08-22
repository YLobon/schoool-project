package com.luna.school.interfaces.rest;


import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.interfaces.facade.query.AnneeScolaireQueryFacade;
import com.luna.school.interfaces.facade.usecase.AnneeScolaireUseCaseFacade;
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
@RequestMapping("/api/luna/scolaire/annee-scolaire")
public class AnnneeScolaireRessource {
private final AnneeScolaireUseCaseFacade anneeScolaireUseCaseFacade;
private final AnneeScolaireQueryFacade anneeScolaireQueryFacade;


  public AnnneeScolaireRessource(AnneeScolaireUseCaseFacade anneeScolaireUseCaseFacade,
      AnneeScolaireQueryFacade anneeScolaireQueryFacade) {
    this.anneeScolaireUseCaseFacade = anneeScolaireUseCaseFacade;
    this.anneeScolaireQueryFacade = anneeScolaireQueryFacade;
  }
  @GetMapping("/lister")
  public ResponseEntity<List<AnneeScolaireEssentielVM>> lister() {
    List<AnneeScolaireEssentielVM> permissions = this.anneeScolaireQueryFacade.lister();
    return ResponseEntity.ok(permissions);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AnneeScolaireDatailsVM> recupererParId(@PathVariable UUID id) {
    AnneeScolaireDatailsVM anneeScolaireDatailsVM =
        this.anneeScolaireQueryFacade.recupererParId(id);
    return ResponseEntity.ok(anneeScolaireDatailsVM);
  }

  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.anneeScolaireUseCaseFacade.supprimer(id);
  }

  @PostMapping("/payer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerAnneeScolaireCommande commande) {
    this.anneeScolaireUseCaseFacade.creer(commande);
  }

  /**
   * <p>Méthode de modification d'un utilisateur connecté.</p>
   *
   * @param commande commande modification d'un utilisateur connecté.
   */
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierAnneeScolaireCammande commande) {
    this.anneeScolaireUseCaseFacade.modifier(commande);
  }

}
