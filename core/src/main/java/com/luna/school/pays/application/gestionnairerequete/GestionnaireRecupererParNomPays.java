package com.luna.school.pays.application.gestionnairerequete;
import com.luna.school.pays.application.casutilisation.RecupererParLibellePays;
import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.tools.GestionnaireRequete;


/**
 * <p>Gestionnaire de requête de récuperation {@link Pays} par libelle.</p>
 *
 * @author BOUA YVES
 */
public class GestionnaireRecupererParNomPays implements GestionnaireRequete<Pays, String> {

  private final RecupererParLibellePays recupererParLibellePays;

  public GestionnaireRecupererParNomPays(PaysRepositoryPort paysRepositoryPort) {
    this.recupererParLibellePays = new RecupererParLibellePays(paysRepositoryPort);
  }

  @Override
  public Pays requete(String libelle) {
    return this.recupererParLibellePays.recupererParNomPays(libelle);
  }
}
