package com.luna.school.comptabilite.application.casutilisation;


import com.luna.school.comptabilite.application.commande.PayerScolariteCommande;
import com.luna.school.comptabilite.application.port.ScolariteRepositoryPort;
import com.luna.school.comptabilite.domaine.entite.Scolarite;
import com.luna.school.comptabilite.domaine.exception.ScolariteException;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.inscription.domaine.entite.Inscription;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-06-15 7:54 p.m..
 */
@Setter
@Getter
public class PayerScolarite {
  private final ScolariteRepositoryPort scolariteRepositoryPort;
  private final EtudiantRepositoryPort etudiantRepositoryPort;
  private final InscriptionRepositoryPort inscriptionRepositoryPort;

  public PayerScolarite(ScolariteRepositoryPort scolariteRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort,
      InscriptionRepositoryPort inscriptionRepositoryPort) {
    this.scolariteRepositoryPort = scolariteRepositoryPort;
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.inscriptionRepositoryPort = inscriptionRepositoryPort;
  }

  public void payerScolarite(PayerScolariteCommande commande){
    Etudiant etudiant = this.etudiantRepositoryPort.recupererParId(commande.getEtudiantId());
    UUID etudiantId = etudiant.getId();
    Inscription inscription = this.inscriptionRepositoryPort.recupererInscriptionParEtudienId(etudiantId);
    BigDecimal scolariteTotale = inscription.getScolarite().getScolariteTotale();
    this.verifierScolarite(scolariteTotale);
    BigDecimal reste = inscription.getScolarite().getReste();
    Scolarite scolarite = inscription.getScolarite();
    scolarite.setEtudiant(etudiant);
    this.verifierPaiement(reste,commande.getMontantVerset());
    this.etudiantPresent(commande.getEtudiantId());
    this.existeParLibelle(commande.getLibelle());
    scolarite.setDatePaiement(commande.getDatePaiement());
    scolarite.setMontantVerset(commande.getMontantVerset());
    BigDecimal montantVerset = commande.getMontantVerset();
    reste = reste.subtract(montantVerset);
    scolarite.setReste(reste);
    this.scolariteRepositoryPort.enregistrer(scolarite);
  }

  private void existeParLibelle(String libelle) {
    boolean existsParLibelle = this.scolariteRepositoryPort.existsParLibelle(libelle);
    if (existsParLibelle){
      throw new ScolariteException("Le libelle est introuvable !");
    }
  }

  private void etudiantPresent(UUID etudiantId) {
    boolean existeParEtudiant = this.scolariteRepositoryPort.existeParEtudiant(etudiantId);
    if (existeParEtudiant){
      throw new ScolariteException("L'étudiant est introuvable !");
    }
  }

  private void verifierScolarite(BigDecimal totalScolarite) {
    int comparaison = totalScolarite.compareTo(BigDecimal.ZERO);

    if (comparaison == 0 || comparaison < 0) {
      throw new ScolariteException("Vous n'aviez pas de scolarité à payer");
    }
  }

  private void verifierPaiement(BigDecimal soldeRestant, BigDecimal montantVerse) {
    int comparaison = montantVerse.compareTo(soldeRestant);

    if (comparaison > 0) {
      throw new ScolariteException("Le montant versé ne doit pas être supérieur au solde restant de la scolarité !");
    }
  }
}
