package com.luna.school.niveau.application.casutilisation;

import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class SupprimerNiveau {
  private final NiveauRepositoryPort niveauRepositoryPort;
  public SupprimerNiveau(NiveauRepositoryPort niveauRepositoryPort
	) {
    this.niveauRepositoryPort = niveauRepositoryPort;
	}

  public void supprimer(UUID niveauId) {
    this.niveauRepositoryPort.supprimer(niveauId);
  }
}
