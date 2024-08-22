package com.luna.school.repository.impl;

import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.entite.MatiereTable;
import com.luna.school.mapper.MatiereMapper;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.repository.JpaMatiereRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 9:15 a.m..
 */
@Service
public class PgMatieRepositoryAdapteur implements MatiereRepositoryPort {

  private final JpaMatiereRepository jpaMatiereRepository;
  private final MatiereMapper matiereMapper;

  public PgMatieRepositoryAdapteur(JpaMatiereRepository jpaMatiereRepository) {
    this.jpaMatiereRepository = jpaMatiereRepository;
    matiereMapper = MatiereMapper.INSTANCE;
  }

  @Override
  public void enregistrer(Matiere matiere) {
    MatiereTable matiereTable = this.matiereMapper.matiereVersMatiereTable(matiere);
    this.jpaMatiereRepository.save(matiereTable);
  }

  @Override
  public Matiere recupererParId(UUID id) {
    Optional<MatiereTable> matiereTableOptional = this.jpaMatiereRepository.findById(id);
    if (matiereTableOptional.isPresent()) {
      MatiereTable matiereTable = matiereTableOptional.get();
      return matiereMapper.matiereTableeVersMatiere(matiereTable);
    } else {
      throw new ClasseExecption("La Matiere est introuvable !");
    }
  }

  @Override
  public boolean existeParNom(String nom) {
    return this.jpaMatiereRepository.existsByNom(nom);
  }

  @Override
  public boolean existsParId(UUID matiereId) {
    return this.jpaMatiereRepository.existsById(matiereId);
  }

  @Override
  public void supprimer(UUID idMatiere) {
    try {
      this.jpaMatiereRepository.deleteById(idMatiere);
    } catch (Exception e) {
      String message = "impossible de supprimer cette Matiere !";
      throw new ClasseExecption(message);
    }
  }

}
