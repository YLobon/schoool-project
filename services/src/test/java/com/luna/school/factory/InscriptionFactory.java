package com.luna.school.factory;

import com.luna.school.entite.ClasseTable;
import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.InscriptionTable;
import com.luna.school.entite.MatiereTable;
import com.luna.school.entite.ScolariteTable;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.etudiant.domaine.objetvaleur.DecisionFinAnnee;
import com.luna.school.repository.JpaInscriptionRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 7:00 a.m..
 */
@Component
public class InscriptionFactory {
private final JpaInscriptionRepository jpaInscriptionRepository;
private final ClasseFactory classeFactory;
private final ScolariteFactory scolariteFactory;
private final MatiereFactory matiereFactory;
private final EtudiantFactory etudiantFactory;

  public InscriptionFactory(JpaInscriptionRepository jpaInscriptionRepository,
      ClasseFactory classeFactory, ScolariteFactory scolariteFactory, MatiereFactory matiereFactory,
      EtudiantFactory etudiantFactory) {
    this.jpaInscriptionRepository = jpaInscriptionRepository;
    this.classeFactory = classeFactory;
    this.scolariteFactory = scolariteFactory;
    this.matiereFactory = matiereFactory;
    this.etudiantFactory = etudiantFactory;
  }

  public InscriptionTable inscription() {
    ScolariteTable scolarite = this.scolariteFactory.scolarite();
    EtudiantTable etudiant = this.genererEtudiant();
    ClasseTable classe = this.classeFactory.classe();
    MatiereTable matiere = this.matiereFactory.matiere();
    var inscription =new InscriptionTable();
    inscription.setId(UUID.randomUUID());
    inscription.setDroitInscription(true);
    inscription.setDateInscription(LocalDate.now());
    inscription.setBoursier(true);
    inscription.setNumeroPiece("01020345");
    inscription.setRedouble(false);
    inscription.setPiece(TypePiece.AUTRE);
    inscription.setLieuNaissance(etudiant.getLieuNaissance());
    inscription.setClasseActuelle(classe);
    inscription.setClassePrecedante(classe);
    inscription.setExtraitNaisaance(true);
    inscription.setDecisionFinAnnee(DecisionFinAnnee.ADMIS);
    inscription.setReleveNote(true);
    inscription.setMatiereFacultatif(matiere);
    inscription.setEtudiant(etudiant);
    inscription.setDeposerPhoto(true);
    inscription.setEtablissementPrecedante("Ecole Pigier");
    inscription.setFairePremierVersement(true);
    inscription.setNumeroExtraitNaissance("12 2254");
    inscription.setScolarite(scolarite);
    return this.jpaInscriptionRepository.save(inscription);
  }

  private EtudiantTable genererEtudiant() {
    return this.etudiantFactory.genererEtudiant();
  }
}
