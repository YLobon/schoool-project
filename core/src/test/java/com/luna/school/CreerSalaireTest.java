package com.luna.school;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.gestionnairecommande.CreerAnneeGestionnairecommande;
import com.luna.school.anneescolaire.application.port.AnneeScolaireRepositoryPort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.factory.AnneeScolaireFactory;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author BOUA YVES 2024-03-21
 */
@ExtendWith(MockitoExtension.class)
class CreerSalaireTest {

  @Mock
  AnneeScolaireRepositoryPort anneeScolaireRepositoryPort;
  @Mock
  AnneeScolaireFactory anneeScolaireFactory;

  CreerAnneeGestionnairecommande creerAnneeGestionnairecommande;

  @BeforeEach
  void setUp() {
    this.creerAnneeGestionnairecommande = new CreerAnneeGestionnairecommande(
        anneeScolaireRepositoryPort
    );
  }

  @Test
  @DisplayName("Test la creation d'une annee scolaire")
  void creer() {
    //Given
    CreerAnneeScolaireCommande commande = new CreerAnneeScolaireCommande();

    commande.setLibelle("2020-2021");
    commande.setDateDebut(LocalDate.of(2020,8,07));
    commande.setDateFin(LocalDate.of(2021,6,28));

    //When
    this.creerAnneeGestionnairecommande.execute(commande);

    //Then
    verify(anneeScolaireRepositoryPort, times(1)).enregistrer(any(AnneeScolaire.class));
  }
}