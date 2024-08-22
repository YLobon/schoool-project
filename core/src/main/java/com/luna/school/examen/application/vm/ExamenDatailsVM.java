package com.luna.school.examen.application.vm;

import com.luna.school.niveau.domaine.entite.Niveau;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-23 1:22 p.m..
 */
@Getter
@Setter
public class ExamenDatailsVM {
  private UUID id;
  private String libelle;
  private Niveau niveau;
  private LocalDate dateDebutComposition;
  private LocalDate dateFinComposition;
}
