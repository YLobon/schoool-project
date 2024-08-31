package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.PersonnelQueryFacade;
import com.luna.school.interfaces.facade.usecase.PersonnelUseCaseFacade;
import com.luna.school.personnel.application.commande.CreerPersonnelCommande;
import com.luna.school.personnel.application.commande.ModifierPersonnelCommande;
import com.luna.school.personnel.application.vm.PersonnelDetailVM;
import com.luna.school.personnel.application.vm.PersonnelEssentielVM;
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
@RequestMapping("/api/luna/scolaire/personnel")
public class PersonnelRessource {

  private final PersonnelUseCaseFacade personnelUseCaseFacade;
  private final PersonnelQueryFacade personnelQueryFacade;

  public PersonnelRessource(PersonnelUseCaseFacade personnelUseCaseFacade,
      PersonnelQueryFacade personnelQueryFacade) {
    this.personnelUseCaseFacade = personnelUseCaseFacade;
    this.personnelQueryFacade = personnelQueryFacade;
  }

  @Operation(summary = "Lister les personnels")
  @GetMapping("/lister")
  public ResponseEntity<List<PersonnelEssentielVM>> lister() {
    List<PersonnelEssentielVM> personnelEssentielVMList = this.personnelQueryFacade.lister();
    return ResponseEntity.ok(personnelEssentielVMList);
  }

  @Operation(summary = "recuperer le personnel par id")
  @GetMapping("/{id}")
  public ResponseEntity<PersonnelDetailVM> recupererParId(@PathVariable UUID id) {
    PersonnelDetailVM personnelDetailVM =
        this.personnelQueryFacade.recupererParId(id);
    return ResponseEntity.ok(personnelDetailVM);
  }

  @Operation(summary = "supprimer un personnel")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.personnelUseCaseFacade.supprimer(id);
  }

  @Operation(summary = "Creer un personnel")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerPersonnelCommande commande) {
    this.personnelUseCaseFacade.creer(commande);
  }

  @Operation(summary = "modifier un personnel")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierPersonnelCommande commande) {
    this.personnelUseCaseFacade.modifier(commande);
  }

}
