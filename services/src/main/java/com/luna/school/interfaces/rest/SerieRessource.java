package com.luna.school.interfaces.rest;


import com.luna.school.interfaces.facade.query.SerieQueryFacade;
import com.luna.school.interfaces.facade.usecase.SerieUseCaseFacade;
import com.luna.school.serie.application.commande.CreerSerieCommande;
import com.luna.school.serie.application.commande.ModifierSerieCommande;
import com.luna.school.serie.application.vm.SerieVM;
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


  @GetMapping("/lister")
  public ResponseEntity<List<SerieVM>> lister() {
    List<SerieVM> serieVMS = this.serieQueryFacade.lister();
    return ResponseEntity.ok(serieVMS);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SerieVM> recupererParId(@PathVariable UUID id) {

    SerieVM serieVM = this.serieQueryFacade.recupererParId(id);
    return ResponseEntity.ok(serieVM);
  }

  @DeleteMapping("supprimer/{id}")
  @ResponseStatus(HttpStatus.OK)
  void supprimer(@PathVariable @Valid UUID id) {
    this.serieUseCaseFacade.supprimer(id);
  }

  @PostMapping("/payer")
  @ResponseStatus(HttpStatus.CREATED)
  public void creer(@Valid @RequestBody CreerSerieCommande commande) {
    this.serieUseCaseFacade.creer(commande);
  }

  @PutMapping("/modifier")
  public void modifier(@Valid @RequestBody ModifierSerieCommande commande) {
    this.serieUseCaseFacade.modifier(commande);
  }

}
