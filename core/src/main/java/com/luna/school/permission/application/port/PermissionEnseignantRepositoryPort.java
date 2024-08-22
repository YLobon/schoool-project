package com.luna.school.permission.application.port;

import com.luna.school.permission.domaine.entite.PermissionEnseignant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface PermissionEnseignantRepositoryPort {

  void enregistrerPermissionEnseignent(PermissionEnseignant permissionEnseignant);

  PermissionEnseignant recupererParId(UUID id);

  void suprimer(UUID id);
}
