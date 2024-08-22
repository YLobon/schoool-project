package com.luna.school.examen.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.examen.application.commande.CreerExamenCommande;
import com.luna.school.examen.application.port.ExamenRepositoryPort;
import com.luna.school.examen.domaine.entite.Examen;
import com.luna.school.examen.domaine.entite.MatiereExamen;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.niveau.application.exception.NiveauException;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.permission.domaine.exception.PermissionException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-23 11:52 a.m..
 */
public class CreerExamen {

  private final NiveauRepositoryPort niveauRepositoryPort;
  private final ClasseRepositoryPort classeRepositoryPort;
  private final ExamenRepositoryPort examenRepositoryPort;

  public CreerExamen(NiveauRepositoryPort niveauRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort, ExamenRepositoryPort examenRepositoryPort) {
    this.niveauRepositoryPort = niveauRepositoryPort;
    this.classeRepositoryPort = classeRepositoryPort;
    this.examenRepositoryPort = examenRepositoryPort;
  }

  public void creerExamen(CreerExamenCommande commande) {
    this.recupererPeriodeExamen(commande.getDateDebut(),commande.getDateFin());
    List<Etudiant> etudiantList = new ArrayList<>();
    Set<MatiereExamen> matiereSet = new HashSet<>();
    Niveau niveau = this.recupererNiveau(commande.getNiveauId());
    List<Classe> classes = this.classeRepositoryPort
        .recupererClasseParNiveauId(commande.getNiveauId());
    for (Classe classe : classes) {
      List<Etudiant> etudiants = classe.getEtudiants();
      etudiantList.add((Etudiant) etudiants);
      List<Matiere> matieres = classe.getMatieres();
      matiereSet.add((MatiereExamen) matieres);
    }
    var examen = new Examen();
    examen.setId(UUID.randomUUID());
    examen.setLibelle(commande.getLibelle());
    examen.setNiveau(niveau);
    examen.setDateDebutComposition(commande.getDateDebut());
    examen.setDateFinComposition(commande.getDateFin());
    examen.setClasses(classes);
    examen.setEtudiants(etudiantList);
    examen.setMatieres(matiereSet);
    this.examenRepositoryPort.enregistrer(examen);
  }

  private Niveau recupererNiveau(UUID id) {
    Niveau niveau = this.niveauRepositoryPort.recupererParId(id);
    if (Objects.nonNull(niveau) && niveau.getId() != null) {
      return niveau;
    } else {
      throw new NiveauException("ce niveau est introuvable !");
    }
  }

  private void recupererPeriodeExamen(LocalDate dateDebut, LocalDate dateFin){
    if (dateFin.isBefore(dateDebut)) {
      throw new PermissionException("La date de fin ne peut pas être avant la date de début !");
    }
  }
}
