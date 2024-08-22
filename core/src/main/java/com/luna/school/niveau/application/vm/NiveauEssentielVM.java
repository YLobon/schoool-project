package com.luna.school.niveau.application.vm;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
public class NiveauEssentielVM {
  private String nom;
  private BigDecimal montantSclarite;
  private String educateur;
}
