package com.luna.school.classe.application.casutilisation;

import com.luna.school.classe.application.commande.AjouterMatierClasseCommande;
import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public class AjouterMatierClasse {

  private final MatiereRepositoryPort matiereRepositoryPort;
  private final ClasseRepositoryPort classeRepositoryPort;

  public AjouterMatierClasse(MatiereRepositoryPort matiereRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort) {
    this.matiereRepositoryPort = matiereRepositoryPort;
    this.classeRepositoryPort = classeRepositoryPort;
  }

  public void ajouterMatierClasse(AjouterMatierClasseCommande commande) {
    this.classeExiste(commande.getClasseId());
    Matiere matiere = this.verifierMatiereInexistante(commande.getMatiereId());
    Classe classe = this.classeRepositoryPort.recupererParId(commande.getClasseId());
    classe.setMatieres(List.of(matiere));
    this.classeRepositoryPort.enregistrer(classe);
  }

  private Matiere verifierMatiereInexistante(UUID idMatiere) {
    Matiere matiere = this.matiereRepositoryPort.recupererParId(idMatiere);
    if (idMatiere != null && Objects.nonNull(matiere)){
      return matiere;
    }else{
      throw new ClasseExecption("Cette matière n'existe pas !");
    }
  }

  private void classeExiste(UUID classeId){
    boolean existeParId = this.classeRepositoryPort.existeParId(classeId);
    if (!existeParId){
      throw new ClasseExecption("Aucune classe n'existe avec l'id:"+classeId);
    }
  }
}
