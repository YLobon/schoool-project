package com.luna.school.entite;

import com.luna.school.luna.AbstractAuditingEntity;
import jakarta.persistence.Entity;
import com.luna.school.pays.domaine.entite.Pays;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>Entité JPA de {@link Pays}.</p>
 *
 * @author mamadou.diarra 2023-09-22
 */
@Getter
@Setter
@Entity
@Table(name = "pays")
public class PaysTable extends AbstractAuditingEntity {

  @Id
  private UUID id;
  private String nom;
}
