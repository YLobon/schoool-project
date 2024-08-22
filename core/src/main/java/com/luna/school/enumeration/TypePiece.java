package com.luna.school.enumeration;

/**
 * @author BOUA YVES 2024-03-18
 */
public enum TypePiece {
  CNI() {
    public String toString() {
      return "Carte nationale d'indentité";
    }
  },

  PASSPORT() {
    public String toString() {
      return "Passport";
    }
  },
  EXTRAIT_NAISSANCE() {
    public String toString() {
      return "Extrait de naissance";
    }
  },
  CERTIFICAT_DE_NATIONNALITE() {
    public String toString() {
      return "Certificat de nationnalité";
    }
  },
  AUTRE() {
    public String toString() {
      return "Autre";
    }
  }
}
