package com.luna.school.permission.application.port;

import com.luna.school.permission.domaine.entite.PermissionPersonnel;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface PermissionPersonnelRepositoryPort {

  void enregistrerPermissionPersonnel(PermissionPersonnel permissionPersonnel);

  PermissionPersonnel recupererParId(UUID id);

  void suprimer(UUID id);
}
