package com.luna.school.pays.domaine.entite;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pays {
  private UUID id;
  private String nom;

}
