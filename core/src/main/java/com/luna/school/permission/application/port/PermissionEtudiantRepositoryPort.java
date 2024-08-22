package com.luna.school.permission.application.port;

import com.luna.school.permission.domaine.entite.PermissionApprenant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface PermissionEtudiantRepositoryPort {

  void enregistrerPermissionEtudiant(PermissionApprenant permissionApprenant);

  PermissionApprenant recupererParId(UUID id);

  void suprimer(UUID id);
}
