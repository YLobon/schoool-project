package com.luna.school.etudiant.domaine.objetvaleur;

/**
 * @author BOUA YVES 2024-04-21
 */
public enum DecisionFinAnnee {
  ADMIS {
    @Override
    public String toString() {
      return "Admis(e)";
    }
  },

  REDOUBLE {
    @Override
    public String toString() {
      return "Redouble";
    }
  },
  EXCLUS {
    @Override
    public String toString() {
      return "Exclus";
    }
  }
}
