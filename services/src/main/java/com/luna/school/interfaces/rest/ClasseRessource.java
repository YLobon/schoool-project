package com.luna.school.interfaces.rest;


import com.luna.school.classe.application.commande.CreerClasseCommande;
import com.luna.school.classe.application.commande.ModifierClasseCommande;
import com.luna.school.classe.application.vm.ClasseDetailVM;
import com.luna.school.classe.application.vm.ClasseEssentielVM;
import com.luna.school.interfaces.facade.query.ClasseQueryFacade;
import com.luna.school.interfaces.facade.usecase.ClasseUseCaseFacade;
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
@RequestMapping("/api/luna/scolaire/classe")
public class ClasseRessource {

  private final ClasseUseCaseFacade classeUseCaseFacade;
  private final ClasseQueryFacade classeQueryFacade;

  public ClasseRessource(ClasseUseCaseFacade classeUseCaseFacade,
      ClasseQueryFacade classeQueryFacade) {
    this.classeUseCaseFacade = classeUseCaseFacade;
    this.classeQueryFacade = classeQueryFacade;
  }

  @Operation(summary = "lister les classes")
  @GetMapping("/lister")
  public ResponseEntity<List<ClasseEssentielVM>> lister() {
    List<ClasseEssentielVM> classeEssentielVMList = this.classeQueryFacade.lister();
    return ResponseEntity.ok(classeEssentielVMList);
  }

  @Operation(summary = "lister les classes par niveau")
  @GetMapping("/{niveauId}/niveau")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ClasseDetailVM>> listerParNiveau(
      @PathVariable("niveauId") UUID niveauId) {
    List<ClasseDetailVM> classeDetailVMS = this.classeQueryFacade.listerParNiveauId(niveauId);
    return new ResponseEntity<>(classeDetailVMS, HttpStatus.OK);
  }

  @Operation(summary = "recuperer une classe par son id")
  @GetMapping("/{id}")
  public ResponseEntity<ClasseDetailVM> recupererParId(@PathVariable UUID id) {
    ClasseDetailVM classeDetailVM = this.classeQueryFacade.recupererParId(id);
    return ResponseEntity.ok(classeDetailVM);
  }

  @Operation(summary = "supprimer une classe")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.classeUseCaseFacade.supprimer(id);
  }

  @Operation(summary = "creer une classe")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerClasseCommande commande) {
    this.classeUseCaseFacade.creer(commande);
  }

  @Operation(summary = "modifier une classe")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierClasseCommande commande) {
    this.classeUseCaseFacade.modifier(commande);
  }

}
