package com.luna.school.factory;


import com.luna.school.entite.ClasseTable;
import com.luna.school.entite.EnseignantTable;
import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.MatiereTable;
import com.luna.school.entite.NoteTable;
import com.luna.school.entite.TrimestreTable;
import com.luna.school.repository.JpaEtudianRepository;
import com.luna.school.repository.JpaNoteRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-09 9:10 a.m..
 */
@Component
public class NoteFactory {

  private final JpaNoteRepository jpaNoteRepository;
  private final EnseignantFactory enseignantFactory;
  private final ClasseFactory classeFactory;
  private final TrimestreFactory trimestreFactory;
  private final PaysFactory paysFactory;
  private final EtudiantFactory etudiantFactory;
  private final MatiereFactory matiereFactory;
  private final JpaEtudianRepository jpaEtudianRepository;

  public NoteFactory(JpaNoteRepository jpaNoteRepository, EnseignantFactory enseignantFactory,
      ClasseFactory classeFactory, TrimestreFactory trimestreFactory, PaysFactory paysFactory,
      EtudiantFactory etudiantFactory,
      MatiereFactory matiereFactory,
      JpaEtudianRepository jpaEtudianRepository) {
    this.jpaNoteRepository = jpaNoteRepository;
    this.enseignantFactory = enseignantFactory;
    this.classeFactory = classeFactory;
    this.trimestreFactory = trimestreFactory;
    this.paysFactory = paysFactory;
    this.etudiantFactory = etudiantFactory;
    this.matiereFactory = matiereFactory;
    this.jpaEtudianRepository = jpaEtudianRepository;
  }


  public NoteTable note() {
    ClasseTable classe = this.classeFactory.classe();
    EtudiantTable etudiantTable = this.genererEtudiant();
    MatiereTable francais = this.matiereFactory.matiereFrancais();
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    var note = new NoteTable();
    note.setId(UUID.randomUUID());
    note.setNote(12.05);
    note.setBareme(20);
    note.setEnseignant(enseignant);
    note.setTrimestre(trimestre);
    note.setEtudiant(etudiantTable);
    note.setClasse(classe);
    note.setMatiere(francais);
    return this.jpaNoteRepository.save(note);
  }

  public NoteTable notes() {
    ClasseTable classe = this.classeFactory.classe();
    EtudiantTable etudiantTable = this.genererEtudiant1();
    MatiereTable francais = this.matiereFactory.matiere();
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    var note = new NoteTable();
    note.setId(UUID.randomUUID());
    note.setNote(12.05);
    note.setBareme(20);
    note.setEnseignant(enseignant);
    note.setTrimestre(trimestre);
    note.setEtudiant(etudiantTable);
    note.setClasse(classe);
    note.setMatiere(francais);
    return this.jpaNoteRepository.save(note);
  }

  public NoteTable notess() {
    ClasseTable classe = this.classeFactory.classe();
    EtudiantTable etudiantTable = this.genererEtudiant2();
    MatiereTable francais = this.matiereFactory.matiereFrancais();
    TrimestreTable trimestre = this.trimestreFactory.trimestre();
    EnseignantTable enseignant = this.enseignantFactory.enseignant();
    var note = new NoteTable();
    note.setId(UUID.randomUUID());
    note.setNote(12.05);
    note.setBareme(20);
    note.setEnseignant(enseignant);
    note.setTrimestre(trimestre);
    note.setEtudiant(etudiantTable);
    note.setClasse(classe);
    note.setMatiere(francais);
    return this.jpaNoteRepository.save(note);
  }

  private EtudiantTable genererEtudiant() {
    return this.etudiantFactory.genererEtudiant();
  }
  private EtudiantTable genererEtudiant1() {
    return this.etudiantFactory.genererEtudiant1();
  }
  private EtudiantTable genererEtudiant2() {
    return this.etudiantFactory.genererEtudiant2();
  }
  private EtudiantTable genererEtudiant3() {
    return this.etudiantFactory.genererEtudiant3();
  }
}
