package com.luna.school.personnel.domaine.objetvaleur;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-07 10:14 a.m..
 */
public enum TypePersonnel {
  PERSONNEL_ADMINISTRATIF {
    @Override
    public String toString() {
      return "Personnel administratif";
    }
  },

  ENSEIGNANT_PERMANENT {
    @Override
    public String toString() {
      return "Enseignant permanent";
    }
  },
  ENSEIGNANT_NON_PERMANENT {
    @Override
    public String toString() {
      return "Enseignant non permanent";
    }
  }
}
