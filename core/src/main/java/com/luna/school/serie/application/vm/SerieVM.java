package com.luna.school.serie.application.vm;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-30 5:50 p.m..
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieVM {
  private UUID id;
  private String libelle;
}
