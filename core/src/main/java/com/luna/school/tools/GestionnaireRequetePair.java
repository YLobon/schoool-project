package com.luna.school.tools;

/**
 * @author BOUA YVES 2024-03-19
 */
public interface GestionnaireRequetePair<R, P1, P2> {
  R requete(P1 var1, P2 var2) throws NonTrouveException;
}
