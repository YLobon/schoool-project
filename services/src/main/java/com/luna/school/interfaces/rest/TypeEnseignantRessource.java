package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.TypeEnseignantQueryFacade;
import com.luna.school.interfaces.facade.usecase.TypeEnseignantUseCaseFacade;
import com.luna.school.typeenseignant.application.commande.CreerTypeEnseignantCommande;
import com.luna.school.typeenseignant.application.commande.ModifierTypeEnseignantCammande;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantDatailsVM;
import com.luna.school.typeenseignant.application.vm.TypeEnseignantEssentielVM;
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
@RequestMapping("/api/luna/scolaire/type-enseignant")
public class TypeEnseignantRessource {

  private final TypeEnseignantUseCaseFacade typeEnseignantUseCaseFacade;
  private final TypeEnseignantQueryFacade typeEnseignantQueryFacade;

  public TypeEnseignantRessource(TypeEnseignantUseCaseFacade typeEnseignantUseCaseFacade,
      TypeEnseignantQueryFacade typeEnseignantQueryFacade) {
    this.typeEnseignantUseCaseFacade = typeEnseignantUseCaseFacade;
    this.typeEnseignantQueryFacade = typeEnseignantQueryFacade;
  }


  @GetMapping("/lister")
  public ResponseEntity<List<TypeEnseignantEssentielVM>> lister() {
    List<TypeEnseignantEssentielVM> enseignantEssentielVMS = this.typeEnseignantQueryFacade.lister();
    return ResponseEntity.ok(enseignantEssentielVMS);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TypeEnseignantDatailsVM> recupererParId(@PathVariable UUID id) {
    TypeEnseignantDatailsVM typeEnseignantDatailsVM =
        this.typeEnseignantQueryFacade.recupererParId(id);
    return ResponseEntity.ok(typeEnseignantDatailsVM);
  }

  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.typeEnseignantUseCaseFacade.supprimer(id);
  }

  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerTypeEnseignantCommande commande) {
    this.typeEnseignantUseCaseFacade.creer(commande);
  }

  /**
   * <p>Méthode de modification d'un utilisateur connecté.</p>
   *
   * @param commande commande modification d'un utilisateur connecté.
   */
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierTypeEnseignantCammande commande) {
    this.typeEnseignantUseCaseFacade.modifier(commande);
  }

}
