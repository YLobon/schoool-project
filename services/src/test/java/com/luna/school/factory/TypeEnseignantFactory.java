package com.luna.school.factory;


import com.luna.school.entite.TypeEnseignantTable;
import com.luna.school.repository.JpaTypeEnseignantRepository;
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
public class TypeEnseignantFactory {

  private final JpaTypeEnseignantRepository jpaAnneeScolaireRepository;

  public TypeEnseignantFactory(JpaTypeEnseignantRepository jpaAnneeScolaireRepository) {
    this.jpaAnneeScolaireRepository = jpaAnneeScolaireRepository;
  }


  public TypeEnseignantTable typeEnseignant(){
    var typeEnseignant = new TypeEnseignantTable();
    typeEnseignant.setId(UUID.randomUUID());
    typeEnseignant.setLibelle("Vacataire");
    typeEnseignant.setSalaireParHeure(1500);
    typeEnseignant.setTaxe(0.15);
    return this.jpaAnneeScolaireRepository.save(typeEnseignant);
  }

  public TypeEnseignantTable typeEnseignant1(){
    var typeEnseignant = new TypeEnseignantTable();
    typeEnseignant.setId(UUID.randomUUID());
    typeEnseignant.setLibelle("non vacataire");
    typeEnseignant.setSalaireParHeure(5000);
    typeEnseignant.setTaxe(0.15);
    return this.jpaAnneeScolaireRepository.save(typeEnseignant);
  }

  public TypeEnseignantTable typeEnseignant2(){
    var typeEnseignant = new TypeEnseignantTable();
    typeEnseignant.setId(UUID.randomUUID());
    typeEnseignant.setLibelle("non vacataire");
    typeEnseignant.setSalaireParHeure(5000);
    typeEnseignant.setTaxe(0.15);
    return this.jpaAnneeScolaireRepository.save(typeEnseignant);
  }

  public TypeEnseignantTable typeEnseignant3(){
    var typeEnseignant = new TypeEnseignantTable();
    typeEnseignant.setId(UUID.randomUUID());
    typeEnseignant.setLibelle("vacataire");
    typeEnseignant.setSalaireParHeure(1500);
    typeEnseignant.setTaxe(0.15);
    return this.jpaAnneeScolaireRepository.save(typeEnseignant);
  }
}
