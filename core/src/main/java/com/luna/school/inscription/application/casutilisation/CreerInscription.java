package com.luna.school.inscription.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.comptabilite.application.port.ScolariteRepositoryPort;
import com.luna.school.comptabilite.domaine.entite.Scolarite;
import com.luna.school.etudiant.application.gestionnairecommande.CreerEtudiantCommende;
import com.luna.school.etudiant.application.gestionnairecommande.CreerParentMereEtudiantCommande;
import com.luna.school.etudiant.application.gestionnairecommande.CreerPereEtudiantCommande;
import com.luna.school.etudiant.application.gestionnairecommande.CreerTuTeurEtudiantCommande;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.ParentEtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.etudiant.domaine.entite.ParentEtudiant;
import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.inscription.domaine.entite.Inscription;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-04-21
 */
public class CreerInscription {
  private final Logger logger = Logger.getLogger(CreerInscription.class.getName());
private final InscriptionRepositoryPort inscriptionRepositoryPort;
private final ParentEtudiantRepositoryPort parentEtudiantRepositoryPort;
private final EtudiantRepositoryPort etudiantRepositoryPort;
private final ClasseRepositoryPort classeRepositoryPort;
private final ScolariteRepositoryPort scolariteRepositoryPort;
private final MatiereRepositoryPort matiereRepositoryPort;
  public CreerInscription(InscriptionRepositoryPort inscriptionRepositoryPort,
      ParentEtudiantRepositoryPort parentEtudiantRepositoryPort,
       EtudiantRepositoryPort etudiantRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort, ScolariteRepositoryPort scolariteRepositoryPort,
      MatiereRepositoryPort matiereRepositoryPort) {
    this.inscriptionRepositoryPort = inscriptionRepositoryPort;
    this.parentEtudiantRepositoryPort = parentEtudiantRepositoryPort;
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.classeRepositoryPort = classeRepositoryPort;
    this.scolariteRepositoryPort = scolariteRepositoryPort;
    this.matiereRepositoryPort = matiereRepositoryPort;
  }

  public void creer(CreerInscriptionCommande commande){
    Inscription inscription = this.genererInscription(commande);
    this.inscriptionRepositoryPort.enregistrer(inscription);
    logger.info("inscription effectuée avec succès !");
  }

  private Inscription genererInscription(CreerInscriptionCommande commande) {
    Classe classePrecedente = this.classeRepositoryPort.recupererParId(commande.getClassePrecedanteId());
    Classe classeActuelle = this.classeRepositoryPort.recupererParId(commande.getClasseActuelleId());
    Matiere matiere = this.matiereRepositoryPort.recupererParId(commande.getIdMatiereFacultatif());

    Etudiant etudiant = this.genererEtudiant(commande.getCreerEtudiantCommende());
    BigDecimal montantScolarite = classeActuelle.getNiveau().getMontantScolarite();
    BigDecimal montantVerset = commande.getMontantVerset();
    var scolarite = new Scolarite();
    scolarite.setId(UUID.randomUUID());
    scolarite.setScolariteTotale(montantScolarite);
    scolarite.setDatePaiement(commande.getDatePaiement());
    scolarite.setMontantVerset(montantVerset);
    BigDecimal reste = montantScolarite.subtract(montantVerset);
    scolarite.setReste(reste);
    scolarite.setEtudiant(etudiant);
    this.scolariteRepositoryPort.enregistrer(scolarite);
    var inscription = new Inscription();
    inscription.setId(UUID.randomUUID());
    inscription.setDateInscription(commande.getDateInscription());
    inscription.setClassePrecedante(classePrecedente);
    inscription.setClasseActuelle(classeActuelle);
    inscription.setMatiereFacultatif(matiere);
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
    inscription.setScolarite(scolarite);
    return inscription;
  }



  private Etudiant genererEtudiant(CreerEtudiantCommende commande) {
    ParentEtudiant parentEtudiant = this.genererParentPere(commande.getParentPereCommande());
    ParentEtudiant parentMereEtudiant = this.genererMere(commande.getParentMereCommande());
    ParentEtudiant tuteurEtudiant = this.genererTuteur(commande.getTuTeurEtudiantCommande());
    var etudiant = new Etudiant();
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(commande.getCivilite());
    etudiant.setStatut(commande.getStatut());
    etudiant.setBoursier(commande.isBoursier());
    etudiant.setMatricule(commande.getMatricule());
    etudiant.setNom(commande.getNom());
    etudiant.setPrenoms(commande.getPrenoms());
    etudiant.setDateNaissance(commande.getDateNaissance());
    etudiant.setLieuNaissance(commande.getLieuNaissance());
    etudiant.setNationnailite(commande.getNationnailite());
    etudiant.setResidence(commande.getResidence());
    etudiant.setDescriptionProbleSante(commande.getDescriptionProbleSante());
    etudiant.setContact(commande.getContact());
    etudiant.setOrphelinDeMere(commande.isOrphelinDeMere());
    etudiant.setOrphelinDesDePere(commande.isOrphelinDesDePere());
    etudiant.setOrphelinDesDeuxParent(commande.isOrphelinDesDeuxParent());
    etudiant.setPere(parentEtudiant);
    etudiant.setMere(parentMereEtudiant);
    etudiant.setTuteur(tuteurEtudiant);
    this.etudiantRepositoryPort.enregistrer(etudiant);
    return etudiant;
  }

  private ParentEtudiant genererParentPere(CreerPereEtudiantCommande commande) {
    var pere = new ParentEtudiant();
    pere.setId(UUID.randomUUID());
    pere.setNom(commande.getNom());
    pere.setPrenoms(commande.getPrenoms());
    pere.setContact(commande.getContact());
    pere.setFonction(commande.getFonction());
    pere.setCivilite(commande.getCivilite());
    pere.setNationnailite(commande.getNationnailite());
    pere.setPiece(commande.getPiece());
    pere.setNumeroPiece(commande.getNumeroPiece());
    pere.setResidence(commande.getResidence());
    this.parentEtudiantRepositoryPort.enregistrer(pere);
    return pere;
  }

  private ParentEtudiant genererMere(CreerParentMereEtudiantCommande commande) {
    var mere = new ParentEtudiant();
    mere.setId(UUID.randomUUID());
    mere.setNom(commande.getNom());
    mere.setPrenoms(commande.getPrenoms());
    mere.setContact(commande.getContact());
    mere.setFonction(commande.getFonction());
    mere.setCivilite(commande.getCivilite());
    mere.setNationnailite(commande.getNationnailite());
    mere.setPiece(commande.getPiece());
    mere.setNumeroPiece(commande.getNumeroPiece());
    mere.setResidence(commande.getResidence());
    this.parentEtudiantRepositoryPort.enregistrer(mere);
    return mere;
  }

  private ParentEtudiant genererTuteur(CreerTuTeurEtudiantCommande commande) {
    var tuteur = new ParentEtudiant();
    tuteur.setId(UUID.randomUUID());
    tuteur.setNom(commande.getNom());
    tuteur.setPrenoms(commande.getPrenoms());
    tuteur.setContact(commande.getContact());
    tuteur.setFonction(commande.getFonction());
    tuteur.setCivilite(commande.getCivilite());
    tuteur.setNationnailite(commande.getNationnailite());
    tuteur.setPiece(commande.getPiece());
    tuteur.setNumeroPiece(commande.getNumeroPiece());
    tuteur.setResidence(commande.getResidence());
    this.parentEtudiantRepositoryPort.enregistrer(tuteur);
    return tuteur;
  }
}
