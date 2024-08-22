package com.luna.school.examen.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.examen.application.commande.AjouterMatiereExamenCommande;
import com.luna.school.examen.application.port.ExamenRepositoryPort;
import com.luna.school.examen.domaine.entite.Examen;
import com.luna.school.examen.domaine.entite.MatiereExamen;
import com.luna.school.examen.domaine.objetvaleur.TypeExamen;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import com.luna.school.niveau.domaine.entite.Niveau;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @author BOUA YVES 2024-06-29 7:36 p.m..
 */
public class AjouterMatiereExamen {
private final MatiereRepositoryPort matiereRepositoryPort;
private final ExamenRepositoryPort examenRepositoryPort;
private final ClasseRepositoryPort classeRepositoryPort;

  public AjouterMatiereExamen(MatiereRepositoryPort matiereRepositoryPort,
      ExamenRepositoryPort examenRepositoryPort, ClasseRepositoryPort classeRepositoryPort) {
    this.matiereRepositoryPort = matiereRepositoryPort;
    this.examenRepositoryPort = examenRepositoryPort;
    this.classeRepositoryPort = classeRepositoryPort;
  }
  public void ajouterMatiere(AjouterMatiereExamenCommande commande){
    Matiere matiere = this.matiereRepositoryPort.recupererParId(commande.getMatiereId());
    List<MatiereExamen> matiereExamenList = this.genererMatiereExamen(commande);
    for (MatiereExamen matiereExamen1 : matiereExamenList){
matiereExamen1.setNom(matiere.getNom());
    }

  }

  private List<MatiereExamen> genererMatiereExamen(AjouterMatiereExamenCommande commande){
    Examen examen = this.examenRepositoryPort.recupererParId(commande.getExamenId());
    TypeExamen typeExamen = commande.getTypeExamen();
    List<MatiereExamen> matiereExamenList = new ArrayList<>();
    if (typeExamen.equals(TypeExamen.BEPC)){
      Niveau niveau = examen.getNiveau();
      List<Classe> classes = this.classeRepositoryPort.recupererClasseParNiveauId(niveau.getId());
      List<Matiere> matieres = classes.get(0).getMatieres();
      var matiereExamen = new MatiereExamen();
      for (Matiere matiere : matieres){
        matiereExamen.setNom(matiere.getNom());
        matiereExamen.setCoefficient(matiere.getCoefficient());
        matiereExamenList.add(matiereExamen);
      }
    }
    return matiereExamenList;
  }
}
