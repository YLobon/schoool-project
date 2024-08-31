package com.luna.school.interfaces.rest;


import com.luna.school.enumeration.Civilite;
import com.luna.school.etudiant.application.vm.EtudiantDetailVM;
import com.luna.school.etudiant.application.vm.EtudiantEssentielVM;
import com.luna.school.etudiant.application.vm.StatistiqueVM;
import com.luna.school.interfaces.facade.query.EtudiantQueryFacade;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author BOUA YVES 2024-03-21
 */
@RestController
@RequestMapping("/api/luna/scolaire/etudiant")
public class EtudiantRessource {

  private final EtudiantQueryFacade etudiantQueryFacade;

  public EtudiantRessource(EtudiantQueryFacade etudiantQueryFacade) {
    this.etudiantQueryFacade = etudiantQueryFacade;
  }
  @Operation(summary = "lister les etudiant")
  @GetMapping("/lister")
  public ResponseEntity<List<EtudiantEssentielVM>> lister() {
    List<EtudiantEssentielVM> lister = this.etudiantQueryFacade.lister();
    return ResponseEntity.ok(lister);
  }
  @Operation(summary = "lister les etudiants par civilité")
  @GetMapping("/{civilite}/civilite")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<EtudiantDetailVM>> listerParCivilite(
      @RequestParam(required = false, name = "civilite") Civilite civilite) {
    List<EtudiantDetailVM> etudiantDetailVMS = this.etudiantQueryFacade.listerParSexe(civilite);
    return new ResponseEntity<>(etudiantDetailVMS, HttpStatus.OK);
  }
  @Operation(summary = "recuperer les etudiants par id")
  @GetMapping("/{id}")
  public ResponseEntity<EtudiantDetailVM> recupererParId(@PathVariable UUID id) {
    EtudiantDetailVM etudiantDetailVM = this.etudiantQueryFacade.recupererParId(id);
    return ResponseEntity.ok(etudiantDetailVM);
  }
  @Operation(summary = "statistique")
  @GetMapping("/statistique")
  public ResponseEntity<StatistiqueVM> statistique() {
    StatistiqueVM statistique = this.etudiantQueryFacade.statistique();
    return ResponseEntity.ok(statistique);
  }

}
