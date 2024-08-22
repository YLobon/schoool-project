package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.PermissionEtudiantQueryFacade;
import com.luna.school.interfaces.facade.usecase.PermissionEtudiantUseCaseFacade;
import com.luna.school.permission.application.commande.CreerPermissionEleveCommande;
import com.luna.school.permission.application.commande.ModifierPermissionEleveCommande;
import com.luna.school.permission.application.vm.PermissionEtudiantVM;
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
@RequestMapping("/api/luna/scolaire/permission-etudiant")
public class PermissionEtudiantRessource {

  private final PermissionEtudiantUseCaseFacade permissionEtudiantUseCaseFacade;
  private final PermissionEtudiantQueryFacade permissionEtudiantQueryFacade;

  public PermissionEtudiantRessource(
      PermissionEtudiantUseCaseFacade permissionEtudiantUseCaseFacade,
      PermissionEtudiantQueryFacade permissionEtudiantQueryFacade) {
    this.permissionEtudiantUseCaseFacade = permissionEtudiantUseCaseFacade;
    this.permissionEtudiantQueryFacade = permissionEtudiantQueryFacade;
  }


  @GetMapping("/lister")
  public ResponseEntity<List<PermissionEtudiantVM>> lister() {
    List<PermissionEtudiantVM> permissionPersonnelVMS = this.permissionEtudiantQueryFacade.lister();
    return ResponseEntity.ok(permissionPersonnelVMS);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PermissionEtudiantVM> recupererParId(@PathVariable UUID id) {

    PermissionEtudiantVM permissionEtudiantVM = this
        .permissionEtudiantQueryFacade.recupererParId(id);
    return ResponseEntity.ok(permissionEtudiantVM);
  }

//  @DeleteMapping("supprimer/{id}")
//  @ResponseStatus(HttpStatus.OK)
//  void supprimer(@PathVariable @Valid UUID id) {
//    this.anneeScolaireUseCaseFacade.supprimer(id);
//  }

  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerPermissionEleveCommande commande) {
    this.permissionEtudiantUseCaseFacade.creer(commande);
  }

  /**
   * <p>Méthode de modification d'un utilisateur connecté.</p>
   *
   * @param commande commande modification d'un utilisateur connecté.
   */
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierPermissionEleveCommande commande) {
    this.permissionEtudiantUseCaseFacade.modifier(commande);
  }

}
