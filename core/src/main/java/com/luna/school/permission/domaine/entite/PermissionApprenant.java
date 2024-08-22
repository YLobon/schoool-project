package com.luna.school.permission.domaine.entite;

import com.luna.school.etudiant.domaine.entite.Etudiant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionApprenant {
  private UUID id;
  private LocalDate dateDebut;
  private LocalDate dateFin;
  private String description;
  private Etudiant etudiant;

}
