package com.luna.school.entite;

import com.luna.school.classe.domaine.objetvaleur.Cycle;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-01 11:22 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "classe")
public class ClasseTable {

  @Id
  private UUID id;
  private String libelle;
  @ManyToOne
  @JoinColumn(name = "serie_id")
  private SerieTable serie;
  @ManyToOne
  @JoinColumn(name = "niveau_id", nullable = false)
  private NiveauTable niveau;
  @Enumerated(EnumType.STRING)
  private Cycle cycle;
  @ManyToOne
  @JoinColumn(name = "professeurPrincipal_id", nullable = true)
  private PersonnelTable professeurPrincipal;
  @OneToMany(mappedBy = "classe")
  private List<EtudiantTable> etudiants;
  @OneToMany(mappedBy = "classe")
  private List<MatiereTable> matieres;
}
