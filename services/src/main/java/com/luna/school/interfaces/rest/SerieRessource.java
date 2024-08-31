package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.SerieQueryFacade;
import com.luna.school.interfaces.facade.usecase.SerieUseCaseFacade;
import com.luna.school.serie.application.commande.CreerSerieCommande;
import com.luna.school.serie.application.commande.ModifierSerieCommande;
import com.luna.school.serie.application.vm.SerieVM;
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
@RequestMapping("/api/luna/scolaire/serie")
public class SerieRessource {

  private final SerieUseCaseFacade serieUseCaseFacade;
  private final SerieQueryFacade serieQueryFacade;

  public SerieRessource(SerieUseCaseFacade serieUseCaseFacade, SerieQueryFacade serieQueryFacade) {
    this.serieUseCaseFacade = serieUseCaseFacade;
    this.serieQueryFacade = serieQueryFacade;
  }

  @Operation(summary = "Lister les serie")
  @GetMapping("/lister")
  public ResponseEntity<List<SerieVM>> lister() {
    List<SerieVM> serieVMS = this.serieQueryFacade.lister();
    return ResponseEntity.ok(serieVMS);
  }

  @Operation(summary = "recuperer la serie par id")
  @GetMapping("/{id}")
  public ResponseEntity<SerieVM> recupererParId(@PathVariable UUID id) {
    SerieVM serieVM = this.serieQueryFacade.recupererParId(id);
    return ResponseEntity.ok(serieVM);
  }

  @Operation(summary = "Supprimer une serie")
  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.serieUseCaseFacade.supprimer(id);
  }

  @Operation(summary = "creer une serie")
  @PostMapping("/creer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerSerieCommande commande) {
    this.serieUseCaseFacade.creer(commande);
  }

  @Operation(summary = "Modifier une serie")
  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierSerieCommande commande) {
    this.serieUseCaseFacade.modifier(commande);
  }

}
