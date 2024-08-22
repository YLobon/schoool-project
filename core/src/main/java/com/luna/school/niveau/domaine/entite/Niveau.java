package com.luna.school.niveau.domaine.entite;

import com.luna.school.personnel.domaine.entite.Personnel;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
@NoArgsConstructor
public class Niveau {
private UUID id;
private String nom;
private Personnel educateur;
private BigDecimal montantScolarite;

  public Niveau(UUID id, String nom, Personnel educateur,BigDecimal montantSclarite) {
    this.id = id;
    this.nom = nom;
    this.educateur = educateur;
    this.montantScolarite = montantSclarite;
  }
}
