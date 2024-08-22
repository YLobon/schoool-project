package com.luna.school.tools;

/**
 * @author BOUA YVES 2024-03-19
 */
public interface GestionnaireRequete<R, P> {
  R requete(P var1) throws NonTrouveException;
}
