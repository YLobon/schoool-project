package com.luna.school.serie.application.vm;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-02
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDetailsVM {
  private UUID id;
  private String libelle;
}
