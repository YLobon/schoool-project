package com.luna.school.classe.application.casutilisation;

import com.luna.school.classe.application.commande.ModifierClasseCommande;
import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.classe.domaine.objetvaleur.Cycle;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.Objects;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public class ModifierClasse {

  private final ClasseRepositoryPort classeRepositoryPort;
  private final NiveauRepositoryPort niveauRepositoryPort;
  private final SerieRepositoryPort serieRepositoryPort;
  private final EnseignantRepositoryPort enseignantRepositoryPort;

  public ModifierClasse(ClasseRepositoryPort classeRepositoryPort,
      NiveauRepositoryPort niveauRepositoryPort, SerieRepositoryPort serieRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort) {
    this.classeRepositoryPort = classeRepositoryPort;
    this.niveauRepositoryPort = niveauRepositoryPort;
    this.serieRepositoryPort = serieRepositoryPort;
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }


  public void modifier(ModifierClasseCommande commande) {
    Classe classe = this.classeRepositoryPort.recupererParId(commande.getClasseId());
    this.verifierLibelle(commande.getLibelle());
    Niveau niveau = this.niveauRepositoryPort.recupererParId(commande.getNiveauId());
    Serie serie = this.serieRepositoryPort.recupererParId(commande.getSerieId());
    Enseignant enseignant = this.enseignantRepositoryPort
        .recupererParId(commande.getProfesseurPrincipalId());
    Cycle cycle = commande.getCycle();
    classe.setId(UUID.randomUUID());
    if (cycle.equals(Cycle.DEUXIEMECYCLE)) {
      this.verifierSerie(serie);
      classe.setSerie(serie);
    }
    classe.setLibelle(commande.getLibelle());
    classe.setNiveau(niveau);
    classe.setSerie(serie);
    classe.setProfesseurPrincipal(enseignant);
    this.classeRepositoryPort.enregistrer(classe);
  }


  private void verifierLibelle(String libelle) {
    boolean existeParLibelle = this.classeRepositoryPort.existsParLibelle(libelle);
    if (existeParLibelle) {
      throw new ClasseExecption("Libelle " + libelle + "existe déjà comme nom de classe");
    }
  }

  private void verifierSerie(Serie serie) {
    if (Objects.nonNull(serie) || serie.getId() == null) {
      throw new ClasseExecption("La serie doit être renseigner pour les deuxieme cycle");
    }
  }

}
