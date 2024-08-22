package com.luna.school.luna;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-05-23
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "parametrage_email_administrateur_school")
public class ParametrageEmailAdministrateurSchoolTable {


  @Id
  private UUID id;
  private String email;
  private String contact;
  private boolean actif;
  @Enumerated(EnumType.STRING)
  private TypeAdministrateurLuna type;
}
