package com.luna.school.factory;


import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.ScolariteTable;
import com.luna.school.repository.JpaScolariteRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class ScolariteFactory {

  private final JpaScolariteRepository jpaScolariteRepository;
  private final AnneScolaireFactory anneScolaireFactory;
  private final EtudiantFactory etudiantFactory;

  public ScolariteFactory(JpaScolariteRepository jpaScolariteRepository,
      AnneScolaireFactory anneScolaireFactory, EtudiantFactory etudiantFactory) {
    this.jpaScolariteRepository = jpaScolariteRepository;
    this.anneScolaireFactory = anneScolaireFactory;
    this.etudiantFactory = etudiantFactory;
  }


  public ScolariteTable scolarite(){
    EtudiantTable etudiant = etudiantFactory.genererEtudiant();
    var scolarite = new ScolariteTable();
    scolarite.setId(UUID.randomUUID());
    scolarite.setLibelle("2024-2025");
   scolarite.setScolariteTotale(BigDecimal.valueOf(200_000.0));
   scolarite.setEtudiant(etudiant);
   scolarite.setId(UUID.randomUUID());
   scolarite.setMontantVerset(BigDecimal.valueOf(100_000.0));
   scolarite.setReste(BigDecimal.valueOf(100_000.0));
   scolarite.setDatePaiement(LocalDate.now());
   scolarite.setLibelle("premerVersement");
    return this.jpaScolariteRepository.save(scolarite);
  }
}
