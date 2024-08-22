package com.luna.school.permission.application.commande;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
public class ModifierPermissionPersonnelCommande extends CreerPermissionPersonnelCommande{
  private UUID permissionId;
}
