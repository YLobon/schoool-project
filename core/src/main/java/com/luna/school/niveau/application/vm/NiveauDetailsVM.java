package com.luna.school.niveau.application.vm;

import java.math.BigDecimal;
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
public class NiveauDetailsVM {
  private UUID id;
  private String nom;
  private BigDecimal montantSclarite;
}
