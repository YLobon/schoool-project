package com.luna.school.factory;

import com.luna.school.entite.EtudiantTable;
import com.luna.school.entite.ParentEtudiantTable;
import com.luna.school.entite.PaysTable;
import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.Statut;
import com.luna.school.repository.JpaEtudianRepository;
import com.luna.school.repository.JpaParentEtudiantRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 10:01 a.m..
 */
@Component
public class EtudiantFactory {

  private final PaysFactory paysFactory;
  private final JpaEtudianRepository jpaEtudianRepository;
  private final JpaParentEtudiantRepository  jpaParentEtudiantRepository;

  public EtudiantFactory(PaysFactory paysFactory, JpaEtudianRepository jpaEtudianRepository,
      JpaParentEtudiantRepository jpaParentEtudiantRepository) {
    this.paysFactory = paysFactory;
    this.jpaEtudianRepository = jpaEtudianRepository;
    this.jpaParentEtudiantRepository = jpaParentEtudiantRepository;
  }

  public EtudiantTable genererEtudiant() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MADAME);
    etudiant.setNom("BOGA");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setPrenoms("Juliette");
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

  private ParentEtudiantTable genererParent() {
    PaysTable pays = this.paysFactory.pays();
    var parentEtudiant = new ParentEtudiantTable();
    parentEtudiant.setId(UUID.randomUUID());
    parentEtudiant.setCivilite(Civilite.MONSIEUR);
    parentEtudiant.setNumeroPiece("Boua");
    parentEtudiant.setPrenoms("Boua");
    parentEtudiant.setContact("02014563");
    parentEtudiant.setFonction("Millitaire");
    parentEtudiant.setNumeroPiece("09 235 441C");
    parentEtudiant.setNationnailite(pays);
    return this.jpaParentEtudiantRepository.save(parentEtudiant);
  }

  private ParentEtudiantTable genererParentMere() {
    PaysTable pays = this.paysFactory.pays();
    var parentEtudiant = new ParentEtudiantTable();
    parentEtudiant.setId(UUID.randomUUID());
    parentEtudiant.setCivilite(Civilite.MADAME);
    parentEtudiant.setNumeroPiece("Tiemoko");
    parentEtudiant.setPrenoms("Becendine");
    parentEtudiant.setContact("0151773886");
    parentEtudiant.setFonction("Menagere");
    parentEtudiant.setNumeroPiece("09 235 441C");
    parentEtudiant.setNationnailite(pays);
    return this.jpaParentEtudiantRepository.save(parentEtudiant);
  }

  public EtudiantTable genererEtudiant1() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MADAME);
    etudiant.setNom("Bamba");
    etudiant.setPrenoms("Massiamy");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

  public EtudiantTable genererEtudiant2() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MONSIEUR);
    etudiant.setNom("Zago");
    etudiant.setPrenoms("Anxtoine");
    etudiant.setStatut(Statut.NON_AFFECTER);
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("aucun problème !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

  public EtudiantTable genererEtudiant3() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MONSIEUR);
    etudiant.setNom("Coulibaly ");
    etudiant.setPrenoms("Idriss");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème de taille");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

  public EtudiantTable genererEtudiant4() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MONSIEUR);
    etudiant.setNom("Tia");
    etudiant.setPrenoms("Julien");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

  public EtudiantTable genererEtudiant5() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MADAME);
    etudiant.setNom("Zadi");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setPrenoms("Micheline");
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

  public EtudiantTable genererEtudiant6() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MONSIEUR);
    etudiant.setNom("Boka");
    etudiant.setPrenoms("Arthur");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }


  public EtudiantTable genererEtudiant7() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MADAME);
    etudiant.setNom("Jorgette");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setPrenoms("Madelaine");
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

  public EtudiantTable genererEtudiant8() {
    PaysTable pays = this.paysFactory.pays();
    var etudiant = new EtudiantTable();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(Civilite.MONSIEUR);
    etudiant.setNom("Konan");
    etudiant.setPrenoms("Milkael");
    etudiant.setStatut(Statut.AFFECTER);
    etudiant.setContact("0142804744");
    etudiant.setMatricule("0048 698");
    etudiant.setBoursier(true);
    etudiant.setNationnailite(pays);
    etudiant.setContactUrgence("02010452896");
    etudiant.setDescriptionProbleSante("Problème est le faite qu'ille mange trop !");
    etudiant.setDateNaissance(LocalDate.of(2002,12,6));
    etudiant.setOrphelinDesDePere(false);
    etudiant.setOrphelinDeMere(false);
    etudiant.setOrphelinDesDeuxParent(false);
    etudiant.setLieuNaissance("Guiberoua");
    etudiant.setResidence("Cocody");
    etudiant.setPere(this.genererParent());
    etudiant.setMere(this.genererParentMere());
    return  this.jpaEtudianRepository.save(etudiant);
  }

}
