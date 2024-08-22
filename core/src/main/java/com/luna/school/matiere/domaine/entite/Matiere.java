package com.luna.school.matiere.domaine.entite;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-02
 */
@Getter
@Setter
public class Matiere {
private UUID id;
private String nom;
private double coefficient;
private boolean sousMatiere;
private List<SousMatiere> sousMatieres;


}
