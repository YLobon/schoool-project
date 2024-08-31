package com.luna.school.interfaces.rest;


import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.inscription.application.commande.ModifierInscriptionCommande;
import com.luna.school.interfaces.facade.usecase.InscriptionUseCaseFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/luna/scolaire/inscription")
public class InscriptionRessource {

  private final InscriptionUseCaseFacade inscriptionUseCaseFacade;

  public InscriptionRessource(InscriptionUseCaseFacade inscriptionUseCaseFacade) {
    this.inscriptionUseCaseFacade = inscriptionUseCaseFacade;
  }

  @Operation(summary = "supprimer l'inscription")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.inscriptionUseCaseFacade.supprimer(id);
  }

  @Operation(summary = "creer inscription")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerInscriptionCommande commande) {
    this.inscriptionUseCaseFacade.creer(commande);
  }

  @Operation(summary = "modifier inscription")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierInscriptionCommande commande) {
    this.inscriptionUseCaseFacade.modifier(commande);
  }

}
