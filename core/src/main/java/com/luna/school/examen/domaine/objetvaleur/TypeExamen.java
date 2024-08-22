package com.luna.school.examen.domaine.objetvaleur;

/**
 * <p> {@link  } .</p>
 *
 * @author BOUA YVES 2024-06-29 7:07 p.m..
 * @Project school
 */
public enum TypeExamen {


  BEPC {
    @Override
    public String toString() {
      return "Brévet d'Etude du Premier Cycle";

    }
  },

  BACCALAUREAT {
    @Override
    public String toString() {
      return "Baccalaureat";
    }
  }
}
