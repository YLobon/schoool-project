package com.luna.school.query.note;

import com.luna.school.entite.ClasseTable;
import com.luna.school.entite.MatiereTable;
import com.luna.school.repository.JpaClasseRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-22 7:52 p.m..
 */
@Service
public class QueryNoteParClasse {
private final JpaClasseRepository jpaClasseRepository;

  public QueryNoteParClasse(JpaClasseRepository jpaClasseRepository) {
    this.jpaClasseRepository = jpaClasseRepository;
  }

  /**
   * Liste les notes des étudiants pour chaque matière et calcule la somme des notes pour chaque matière.
   * @param classeId L'ID de la classe.
   * @return Une map où la clé est le nom de la matière et la valeur est la somme des notes.
   */
  public Map<String, Double> listerEtSommerNotes(UUID classeId) {
    ClasseTable classe = this.jpaClasseRepository.findById(classeId).orElseThrow(() -> new IllegalArgumentException("Classe non trouvée"));

    Map<String, Double> sommeDesNotesParMatiere = new HashMap<>();

    for (MatiereTable matiere : classe.getMatieres()) {
      double sommeNotes = 0;

//      for (EtudiantTable etudiant : classe.getEtudiants()) {
//        String nom = etudiant.getNom();
        // Vous pouvez ajuster cela selon la structure de votre modèle pour obtenir la note de l'étudiant pour cette matière
        // Par exemple, si vous avez une entité NoteTable qui lie les étudiants et les matières.
        sommeNotes += matiere.getNote(); // Suppose que la note est une propriété de MatiereTable


      sommeDesNotesParMatiere.put(matiere.getNom(), sommeNotes);
    }

    return sommeDesNotesParMatiere;
  }
}
