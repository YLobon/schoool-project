package com.luna.school.classe.application.vm;

import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.UUID;
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
public class ClasseDetailVM {
  private UUID id;
  private String libelle;
  private Serie serie;
  private Niveau niveau;
  private Enseignant professeurPrincipal;
}
