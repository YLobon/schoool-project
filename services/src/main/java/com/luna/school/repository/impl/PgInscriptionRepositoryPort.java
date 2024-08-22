package com.luna.school.repository.impl;

import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.entite.InscriptionTable;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.inscription.domaine.entite.Inscription;
import com.luna.school.mapper.InscriptionMapper;
import com.luna.school.repository.JpaInscriptionRepository;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 6:43 a.m..
 */
@Repository
@Transactional
public class PgInscriptionRepositoryPort implements InscriptionRepositoryPort {

  private final JpaInscriptionRepository jpaInscriptionRepository;
  private final InscriptionMapper inscriptionMapper;

  public PgInscriptionRepositoryPort(JpaInscriptionRepository jpaInscriptionRepository) {
    this.jpaInscriptionRepository = jpaInscriptionRepository;

    inscriptionMapper = InscriptionMapper.INSTANCE;
  }

  @Override
  public void enregistrer(Inscription inscription) {
    InscriptionTable inscriptionTable = this.inscriptionMapper
        .inscriptionVersInscriptionTable(inscription);
    this.jpaInscriptionRepository.save(inscriptionTable);
  }

  @Override
  public Inscription recupereParId(UUID id) {
    Optional<InscriptionTable> inscriptionTableOptional = this.jpaInscriptionRepository.findById(
        id);
    if (inscriptionTableOptional.isPresent()) {
      InscriptionTable inscriptionTable = inscriptionTableOptional.get();
      return inscriptionMapper.inscriptionTableVersInscription(inscriptionTable);
    } else {
      throw new ClasseExecption("L'incription est introuvable !");
    }
  }

  @Override
  public void supprimer(UUID idInscription) {
    try {
      this.jpaInscriptionRepository.deleteById(idInscription);
    } catch (Exception e) {
      String message = "impossible de supprimer cette inscription !";
      throw new ClasseExecption(message);
    }
  }

  @Override
  public Inscription recupererInscriptionParEtudienId(UUID etudiantId) {
    InscriptionTable inscriptionTable = this.jpaInscriptionRepository.findByEtudiantId(etudiantId);
    return this.inscriptionMapper.inscriptionTableVersInscription(inscriptionTable);
  }
}
