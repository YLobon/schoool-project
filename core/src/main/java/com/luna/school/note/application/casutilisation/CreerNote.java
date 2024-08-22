package com.luna.school.note.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.note.application.commande.CreerNoteCommande;
import com.luna.school.note.application.port.NoteRepositoryPort;
import com.luna.school.note.domaine.entite.Note;
import com.luna.school.note.domaine.exception.NoteException;
import com.luna.school.trimestre.application.port.TrimestreRepositoryPort;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-09 9:08 p.m..
 */
public class CreerNote {

  private final ClasseRepositoryPort classeRepositoryPort;
  private final EtudiantRepositoryPort etudiantRepositoryPort;
  private final EnseignantRepositoryPort enseignantRepositoryPort;
  private final TrimestreRepositoryPort trimestreRepositoryPort;
  private final NoteRepositoryPort noteRepositoryPort;
  private final MatiereRepositoryPort matiereRepositoryPort;

  public CreerNote(ClasseRepositoryPort classeRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort,
      TrimestreRepositoryPort trimestreRepositoryPort, NoteRepositoryPort noteRepositoryPort,
      MatiereRepositoryPort matiereRepositoryPort) {
    this.classeRepositoryPort = classeRepositoryPort;
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.enseignantRepositoryPort = enseignantRepositoryPort;
    this.trimestreRepositoryPort = trimestreRepositoryPort;
    this.noteRepositoryPort = noteRepositoryPort;
    this.matiereRepositoryPort = matiereRepositoryPort;
  }

  public void creer(CreerNoteCommande commande) {
    Classe classe = this.classeRepositoryPort.recupererParId(commande.getClasseId());
    Etudiant etudiant = this.etudiantRepositoryPort.recupererParId(commande.getEtudiantId());
    Enseignant enseignant = this.enseignantRepositoryPort.recupererParId(
        commande.getEnseignantId());
    Trimestre trimestre = this.trimestreRepositoryPort.recupererParId(commande.getTrimestreId());
    Matiere matiere = this.matiereRepositoryPort.recupererParId(commande.getMatiereId());
    this.verifierNote(commande.getNote(), commande.getBareme());
    var note = new Note();
    note.setId(UUID.randomUUID());
    note.setClasse(classe);
    note.setNote(commande.getNote());
    note.setBareme(commande.getBareme());
    note.setEtudiant(etudiant);
    note.setEnseignant(enseignant);
    note.setTrimestre(trimestre);
    note.setMatiere(matiere);
    this.noteRepositoryPort.enregistrer(note);
  }

  private void verifierNote(double note, double bareme) {
    if (note > bareme) {
      throw new NoteException("la note ne doit pas être élevé que le bareme");
    }
  }
}
