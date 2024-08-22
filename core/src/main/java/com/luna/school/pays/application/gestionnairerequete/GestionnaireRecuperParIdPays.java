package com.luna.school.pays.application.gestionnairerequete;


import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.domaine.entite.Pays;
import com.luna.school.tools.GestionnaireRequete;
import com.luna.school.tools.NonTrouveException;
import java.util.UUID;

/**
 * <p>Gestionnaire de requête de récuperation {@link Pays} par identifiant.</p>
 *
 * @author BOUA YVES
 */
public class GestionnaireRecuperParIdPays implements GestionnaireRequete<Pays, UUID> {

  private final PaysRepositoryPort paysRepositoryPort;

  public GestionnaireRecuperParIdPays(PaysRepositoryPort paysRepositoryPort) {
    this.paysRepositoryPort = paysRepositoryPort;
  }

  @Override
  public Pays requete(UUID id) {
    return this.paysRepositoryPort.recupererParId(id).orElseThrow(
        () -> new NonTrouveException("Aucun pays trouvé pour cet " + id));
  }
}
