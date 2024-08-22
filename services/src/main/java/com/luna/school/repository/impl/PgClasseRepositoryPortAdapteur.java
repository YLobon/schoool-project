package com.luna.school.repository.impl;

import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.application.vm.ClasseEssentielVM;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.entite.ClasseTable;
import com.luna.school.mapper.ClasseMapper;
import com.luna.school.repository.JpaClasseRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-01 1:08 p.m..
 */
@Repository
public class PgClasseRepositoryPortAdapteur implements ClasseRepositoryPort {
private final JpaClasseRepository jpaClasseRepository;
private final ClasseMapper classeMapper;

  public PgClasseRepositoryPortAdapteur(JpaClasseRepository jpaClasseRepository) {
    this.jpaClasseRepository = jpaClasseRepository;
    classeMapper = ClasseMapper.INSTANCE;
  }

  @Override
  public boolean existsParLibelle(String libelle) {
    return this.jpaClasseRepository.existsByLibelle(libelle);
  }

  @Override
  public void enregistrer(Classe classe) {
    ClasseTable classeTable = this.classeMapper.classeVersClasseTable(classe);
    this.jpaClasseRepository.save(classeTable);
  }

  @Override
  public Classe recupererParId(UUID classeId) {
    Optional<ClasseTable> classeTableOptional = this.jpaClasseRepository.findById(classeId);
    if (classeTableOptional.isPresent()){
      ClasseTable classeTable = classeTableOptional.get();
      return this.classeMapper.classeTableVersClasse(classeTable);
    }else {
      throw new ClasseExecption("La classe est introuvable !");
    }
  }

  @Override
  public List<ClasseEssentielVM> lister() {
    List<ClasseTable> classeTableList = this.jpaClasseRepository.findAll();
    return classeTableList.stream()
        .map(this.classeMapper::classeTableVersClasseEssentielVM).collect(Collectors.toList());

  }

  @Override
  public boolean existeParId(UUID classeId) {
    return this.jpaClasseRepository.existsById(classeId);
  }

  @Override
  public void supprimer(UUID classeId) {
    try{
      this.jpaClasseRepository.deleteById(classeId);
    } catch (Exception e) {
      String message = "impossible de supprimer cette classe !";
      throw new ClasseExecption(message);
    }
  }

  @Override
  public List<Classe> recupererClasseParNiveauId(UUID niveauId) {
      List<ClasseTable> classeTables = this.jpaClasseRepository
          .findByNiveauId(niveauId);
      return classeTables.stream()
          .map(this.classeMapper::classeTableVersClasse).toList();
  }
}
