package com.luna.school.pays.application.vm;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Classe de {@link Pays} VM.</p>
 *
 * @author BOUA YVES
 */
@Getter
@Setter
public class PaysVM {
  private UUID id;
  private String nom;

  public PaysVM(UUID id, String nom) {
    this.id = id;
    this.nom = nom;
  }
}
