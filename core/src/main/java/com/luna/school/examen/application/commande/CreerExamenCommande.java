package com.luna.school.examen.application.commande;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-23 11:41 a.m..
 */
@Getter
@Setter
public class CreerExamenCommande {

  private String libelle;
  private UUID niveauId;
  private LocalDate dateDebut;
  private LocalDate dateFin;

}
