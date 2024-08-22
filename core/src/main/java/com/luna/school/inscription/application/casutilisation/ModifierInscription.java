package com.luna.school.inscription.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.comptabilite.domaine.entite.Scolarite;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.ParentEtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.etudiant.domaine.entite.ParentEtudiant;
import com.luna.school.inscription.application.commande.ModifierInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.inscription.domaine.entite.Inscription;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-04-21
 */

public class ModifierInscription {

  private final InscriptionRepositoryPort inscriptionRepositoryPort;
  private final ParentEtudiantRepositoryPort parentEtudiantRepositoryPort;
  private final EtudiantRepositoryPort etudiantRepositoryPort;
  private final ClasseRepositoryPort classeRepositoryPort;
  private final Logger logger = Logger.getLogger(ModifierInscriptionCommande.class.getName());


  public ModifierInscription(InscriptionRepositoryPort inscriptionRepositoryPort,
      ParentEtudiantRepositoryPort parentEtudiantRepositoryPort,
       EtudiantRepositoryPort etudiantRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort) {
    this.inscriptionRepositoryPort = inscriptionRepositoryPort;
    this.parentEtudiantRepositoryPort = parentEtudiantRepositoryPort;
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.classeRepositoryPort = classeRepositoryPort;
  }

  public void modifier(ModifierInscriptionCommande commande) {
    Inscription inscription = this.genererInscription(commande);
    this.inscriptionRepositoryPort.enregistrer(inscription);
    logger.info("inscription effectuée avec succès !");
  }


    private Inscription genererInscription(ModifierInscriptionCommande commande) {
    Classe classePrecedente = this.classeRepositoryPort.recupererParId(commande.getClassePrecedanteId());
    Classe classeActuelle = this.classeRepositoryPort.recupererParId(commande.getClasseActuelleId());
      Inscription inscription = this.inscriptionRepositoryPort.recupereParId(commande.getId());
      Etudiant etudiant1 = this.etudiantRepositoryPort.recupererParId(
          inscription.getEtudiant().getId());
      Etudiant etudiant = this.modifierEtudiant(commande,etudiant1.getId());
    BigDecimal montantScolarite = classeActuelle.getNiveau().getMontantScolarite();
    BigDecimal montantVerset = commande.getMontantVerset();
    var comptabilite = new Scolarite();
    comptabilite.setId(UUID.randomUUID());
    comptabilite.setScolariteTotale(montantScolarite);
    comptabilite.setMontantVerset(montantVerset);
    BigDecimal reste = montantScolarite.subtract(montantVerset);
    comptabilite.setReste(reste);
    comptabilite.setEtudiant(etudiant);
    inscription.setDateInscription(LocalDate.now());
    inscription.setClassePrecedante(classePrecedente);
    inscription.setClasseActuelle(classeActuelle);
    inscription.setDroitInscription(commande.isDroitInscription());
    inscription.setBoursier(commande.isBoursier());
    inscription.setRedouble(commande.isRedouble());
    inscription.setDecisionFinAnnee(commande.getDecisionFinAnnee());
    inscription.setDeposerPhoto(commande.isDeposerPhoto());
    inscription.setEtablissementPrecedante(commande.getEtablissementPrecedante());
    inscription.setFairePremierVersement(commande.isFairePremierVersement());
    inscription.setLieuNaissance(commande.getCreerEtudiantCommende().getLieuNaissance());
    inscription.setExtraitNaisaance(commande.isExtraitNaisaance());
    inscription.setNumeroExtraitNaissance(commande.getNumeroExtraitNaissance());
    inscription.setEtudiant(etudiant);
    return inscription;
  }


  //informationEtudiant
  private Etudiant modifierEtudiant(ModifierInscriptionCommande commande,UUID idEtudiant){
    Etudiant etudiant = this.etudiantRepositoryPort.recupererParId(idEtudiant);
    UUID idMereEtudiant = etudiant.getMere().getId();
    UUID idPereEtudiant = etudiant.getPere().getId();
    UUID idTuteurEtudiant = etudiant.getTuteur().getId();
    ParentEtudiant mereEtudiant = this.modifierMere(commande, idMereEtudiant);
    ParentEtudiant parentEtudiant = this.modifierPere(commande, idPereEtudiant);
    ParentEtudiant tuteurEtudiant = this.modifierTuteur(commande, idTuteurEtudiant);
    etudiant.setCivilite(commande.getCreerEtudiantCommende().getCivilite());
    etudiant.setStatut(commande.getCreerEtudiantCommende().getStatut());
    etudiant.setBoursier(commande.getCreerEtudiantCommende().isBoursier());
    etudiant.setMatricule(commande.getCreerEtudiantCommende().getMatricule());
    etudiant.setNom(commande.getCreerEtudiantCommende().getNom());
    etudiant.setPrenoms(commande.getCreerEtudiantCommende().getPrenoms());
    etudiant.setDateNaissance(commande.getCreerEtudiantCommende().getDateNaissance());
    etudiant.setLieuNaissance(commande.getCreerEtudiantCommende().getLieuNaissance());
    etudiant.setNationnailite(commande.getCreerEtudiantCommende().getNationnailite());
    etudiant.setResidence(commande.getCreerEtudiantCommende().getResidence());
    etudiant.setDescriptionProbleSante(commande.getCreerEtudiantCommende().getDescriptionProbleSante());
    etudiant.setContact(commande.getCreerEtudiantCommende().getContact());
    etudiant.setOrphelinDeMere(commande.getCreerEtudiantCommende().isOrphelinDeMere());
    etudiant.setOrphelinDesDePere(commande.getCreerEtudiantCommende().isOrphelinDesDePere());
    etudiant.setOrphelinDesDeuxParent(commande.getCreerEtudiantCommende().isOrphelinDesDeuxParent());
    etudiant.setPere(parentEtudiant);
    etudiant.setMere(mereEtudiant);
    etudiant.setTuteur(tuteurEtudiant);
    this.etudiantRepositoryPort.enregistrer(etudiant);
    return etudiant;
  }




  //bloc de renseignement des information des parents

  private ParentEtudiant modifierPere(ModifierInscriptionCommande commande,UUID idPereEtudiant){
    ParentEtudiant parentEtudiant = this.parentEtudiantRepositoryPort.recupererParId(idPereEtudiant);
    parentEtudiant.setNom(commande.getCreerEtudiantCommende().getParentPereCommande().getNom());
    parentEtudiant.setPrenoms(commande.getCreerEtudiantCommende().getParentPereCommande().getPrenoms());
    parentEtudiant.setContact(commande.getCreerEtudiantCommende().getParentPereCommande().getContact());
    parentEtudiant.setFonction(commande.getCreerEtudiantCommende().getParentPereCommande().getFonction());
    parentEtudiant.setCivilite(commande.getCreerEtudiantCommende().getParentPereCommande().getCivilite());
    parentEtudiant.setNationnailite(commande.getCreerEtudiantCommende().getParentPereCommande().getNationnailite());
    parentEtudiant.setPiece(commande.getCreerEtudiantCommende().getParentPereCommande().getPiece());
    parentEtudiant.setNumeroPiece(commande.getCreerEtudiantCommende().getParentPereCommande().getNumeroPiece());
    parentEtudiant.setResidence(commande.getCreerEtudiantCommende().getParentPereCommande().getResidence());
    this.parentEtudiantRepositoryPort.enregistrer(parentEtudiant);
    return parentEtudiant;
  }

  private ParentEtudiant modifierMere(ModifierInscriptionCommande commande,UUID idMereEtudiant) {
    ParentEtudiant mereEtudiant = this.parentEtudiantRepositoryPort.recupererParId(
        idMereEtudiant);
    mereEtudiant.setNom(commande.getCreerEtudiantCommende().getParentMereCommande().getNom());
    mereEtudiant.setPrenoms(commande.getCreerEtudiantCommende().getParentMereCommande().getPrenoms());
    mereEtudiant.setContact(commande.getCreerEtudiantCommende().getParentMereCommande().getContact());
    mereEtudiant.setFonction(commande.getCreerEtudiantCommende().getParentMereCommande().getFonction());
    mereEtudiant.setCivilite(commande.getCreerEtudiantCommende().getParentMereCommande().getCivilite());
    mereEtudiant.setNationnailite(commande.getCreerEtudiantCommende().getParentMereCommande().getNationnailite());
    mereEtudiant.setPiece(commande.getCreerEtudiantCommende().getParentMereCommande().getPiece());
    mereEtudiant.setNumeroPiece(commande.getCreerEtudiantCommende().getParentMereCommande().getNumeroPiece());
    mereEtudiant.setResidence(commande.getCreerEtudiantCommende().getParentMereCommande().getResidence());
    this.parentEtudiantRepositoryPort.enregistrer(mereEtudiant);
    return mereEtudiant;
  }

  private ParentEtudiant modifierTuteur(ModifierInscriptionCommande commande,UUID idTuteurEtudiant) {
    ParentEtudiant tuteurEtudiant = this.parentEtudiantRepositoryPort.recupererParId(
        idTuteurEtudiant);
    tuteurEtudiant.setNom(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getNom());
    tuteurEtudiant.setPrenoms(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getPrenoms());
    tuteurEtudiant.setContact(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getContact());
    tuteurEtudiant.setFonction(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getFonction());
    tuteurEtudiant.setCivilite(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getCivilite());
    tuteurEtudiant.setNationnailite(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getNationnailite());
    tuteurEtudiant.setPiece(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getPiece());
    tuteurEtudiant.setNumeroPiece(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getNumeroPiece());
    tuteurEtudiant.setResidence(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getResidence());
    this.parentEtudiantRepositoryPort.enregistrer(tuteurEtudiant);
    return tuteurEtudiant;
  }



}
