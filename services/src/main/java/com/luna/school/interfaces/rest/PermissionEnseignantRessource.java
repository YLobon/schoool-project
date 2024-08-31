package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.PermissionEnseignantQueryFacade;
import com.luna.school.interfaces.facade.usecase.PermissionEnseignantUseCaseFacade;
import com.luna.school.permission.application.commande.CreerPermissionEnseignantCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEnseignantCommande;
import com.luna.school.permission.application.vm.PermissionEnseignantVM;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/luna/scolaire/permission-enseignant")
public class PermissionEnseignantRessource {

  private final PermissionEnseignantUseCaseFacade permissionEnseignantUseCaseFacade;
  private final PermissionEnseignantQueryFacade permissionEnseignantQueryFacade;

  public PermissionEnseignantRessource(
      PermissionEnseignantUseCaseFacade permissionEnseignantUseCaseFacade,
      PermissionEnseignantQueryFacade permissionEnseignantQueryFacade) {
    this.permissionEnseignantUseCaseFacade = permissionEnseignantUseCaseFacade;
    this.permissionEnseignantQueryFacade = permissionEnseignantQueryFacade;
  }

  @Operation(summary = "Lister les permissions des enseignants")
  @GetMapping("/lister")
  public ResponseEntity<List<PermissionEnseignantVM>> lister() {
    List<PermissionEnseignantVM> permissionPersonnelVMS = this.permissionEnseignantQueryFacade.lister();
    return ResponseEntity.ok(permissionPersonnelVMS);
  }

  @Operation(summary = "recuperer le une permission par id")
  @GetMapping("/{id}")
  public ResponseEntity<PermissionEnseignantVM> recupererParId(@PathVariable UUID id) {

    PermissionEnseignantVM permissionPersonnelVM = this
        .permissionEnseignantQueryFacade.recupererParId(id);
    return ResponseEntity.ok(permissionPersonnelVM);
  }

  //  @DeleteMapping("supprimer/{id}")
//  @ResponseStatus(HttpStatus.OK)
//  void supprimer(@PathVariable @Valid UUID id) {
//    this.anneeScolaireUseCaseFacade.supprimer(id);
//  }
  @Operation(summary = "creer une permission d'enseignant")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerPermissionEnseignantCommande commande) {
    this.permissionEnseignantUseCaseFacade.creer(commande);
  }

  /**
   * <p>Méthode de modification d'un utilisateur connecté.</p>
   *
   * @param commande commande modification d'un utilisateur connecté.
   */
  @Operation(summary = "modifier une permission d'enseigant")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierPermissionEnseignantCommande commande) {
    this.permissionEnseignantUseCaseFacade.modifier(commande);
  }

}
