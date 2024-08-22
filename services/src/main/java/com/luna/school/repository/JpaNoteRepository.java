package com.luna.school.repository;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.MatiereTable;
import com.luna.school.entite.NoteTable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-02 9:14 a.m..
 */
public interface JpaNoteRepository extends JpaRepository<NoteTable, UUID> {

  List<NoteTable> findByMatiereId(UUID matiereId);

  List<NoteTable> findByEtudiantAndMatiere(EtudiantTable etudiant, MatiereTable matiere);

  List<NoteTable> findByClasseIdAndMatiereId(UUID classeId, UUID matiereId);
}
