package com.luna.school.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @author BOUA YVES 2024-05-30 5:42 p.m..
 */
@Getter
@Setter
@Entity
@Table(name = "serie")
public class SerieTable {

  @Id
  @Column(nullable = false)
  private UUID id;
  @Column(nullable = false)
  private String libelle;
}
