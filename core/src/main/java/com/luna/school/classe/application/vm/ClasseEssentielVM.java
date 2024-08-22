package com.luna.school.classe.application.vm;

import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.serie.domaine.entite.Serie;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 5:44 a.m..
 */
@Setter
@Getter
public class ClasseEssentielVM {
  private String libelle;
  private Serie serie;
  private Niveau niveau;
}
