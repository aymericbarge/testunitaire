package com.testunitaire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ParkingTest {

    @Test
    // contexte_methodeSousTest_resulat
    public void vehiculeAutorisesEstVide_ajouterVehiculeAutorises_vehiculeAutorisesNestPlusVide() {
        // AAA : Arrange (preparer), Act (agir), Assert(vérification)

        // Arrange : je mets en place mon test, notamment en instanciant
        Parking parking = new Parking(0);
        // Et initialisant le ou les objets concernés

        // Act : j'appelle la méthode qui est sous test

        parking.ajouterVehiculeAutorises("ABC-123");

        // Assert : Je vérifie que tout s'est bien passé comme prévu
        assertEquals(1, parking.getTailleVehiculeAutorises());

    }

    @Test
    public void vehiculeAutorisesDansLaListe_ajouterLeMemeVehiculeAutorises_devraisNePasEtreAjouter() {
        // Arrange
        Parking parking = new Parking(0);
        parking.ajouterVehiculeAutorises("ABC-123");
        // Act

        parking.ajouterVehiculeAutorises("ABC-123");

        // Assert
        assertEquals(1, parking.getTailleVehiculeAutorises());

    }

    @Test
    public void vehiculeAutorisesDansLaListe_ajouterUnAutreVehiculeAutorises_devraisEtreAjouter() {
        // Arrange
        Parking parking = new Parking(0);
        parking.ajouterVehiculeAutorises("ABC-123");
        // Act

        parking.ajouterVehiculeAutorises("DEF-123");

        // Assert
        assertEquals(2, parking.getTailleVehiculeAutorises());

    }

    @Test
    public void vehiculeAutorises_enregistrerEntreeVehicule_devraitEntree() {
        // Arrange
        Parking parking = new Parking(1);

        // Act
        parking.ajouterVehiculeAutorises("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");

        // Assert
        assertEquals(1, parking.getTailleVehiculeAutorises());
    }

    @Test
    public void sortieVehiculeAutorises_enregistrerSortieVehiculeAutorises_devraitEtreSortie() {
        // Arrange
        Parking parking = new Parking(1);
        Voiture vehicule = new Voiture("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");
        // Act
        parking.enregistrerSortieVehicule("ABC-123");

        // Assert
        assertEquals(0, parking.getTailleVehiculeAutorises());
    }

    @Test
    public void rechercheVehicule_rechercherVehiculeParking_vehiculeEstTrouver() {
        // Arrange
        Parking parking = new Parking(1);
        // Act
        parking.ajouterVehiculeAutorises("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");

        // Assert
        assertEquals(true, parking.rechercherVehiculeParking("ABC-123"));
    }

    @Test
    public void rechercheNombreVehiculeStationnes_getNombreVehiculeStationnes_nombreVehiculeStationnes() {
        // Arrange
        Parking parking = new Parking(1);
        // Act
        parking.ajouterVehiculeAutorises("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");

        // Assert
        assertEquals(1, parking.getNombreVehiculeStationnes());
    }

    @Test
    public void rechercheParkingPlein_parkingPLein_leParkingEstPlein() {
        // Arrange
        Parking parking = new Parking(1);
        // Act
        parking.ajouterVehiculeAutorises("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");
        parking.ajouterVehiculeAutorises("DEF-456");
        parking.enregistrerEntreeVehicule("DEF-456");
        // Assert
        assertEquals(false, parking.parkingPlein());
    }

    @Test
    public void affichageVehiculeStationnes_affichageVehiculeStationnes_lesVehiculeStationnesSontAffiches() {
        // Arrange
        Parking parking = new Parking(1);
        // Act
        parking.ajouterVehiculeAutorises("ABC-123");
        parking.enregistrerEntreeVehicule("ABC-123");
        ArrayList<String> vehiculesStationnes = parking.getVehiculeStationnees();
        // Assert
        assertTrue(vehiculesStationnes.contains("ABC-123"));

    }

    @Test
    public void affichageVehiculeAutorises_affichageVehiculeAutorises_lesVehiculeAutorisesSontAffiches() {
        // Arrange
        Parking parking = new Parking(1);
        // Act
        parking.ajouterVehiculeAutorises("ABC-123");
        ArrayList<String> vehiculesAutorises = parking.getVehiculeAutorises();
        // Assert (You can add assertions here if needed)
        assertTrue(vehiculesAutorises.contains("ABC-123"));

    }

    @Test
    public void calculerLeTauxDeRemplissageZeroPlace_calculerTauxRemplissage_donneLeTauxDeRemplissage() {
        // Arrange
        Parking parking = new Parking(0);
        // Act
        double tauxRemplissage = parking.calculerTauxRemplissage();
        // Assert
        assertEquals(0.0, tauxRemplissage, 0.01);
    }

    @Test
    public void calculerLeTauxDeRemplissageAvec100Vehicules_calculerTauxRemplissage_donneLeTauxDeRemplissage() {
        // Arrange
        Parking parking = new Parking(100);
        for (int i = 0; i < 100; i++) {
            parking.ajouterVehiculeAutorises("ABC-" + i);
            parking.enregistrerEntreeVehicule("ABC-" + i);
        }
        // Act
        double tauxRemplissage = parking.calculerTauxRemplissage();
        // Assert
        assertEquals(100.0, tauxRemplissage, 0.01);
    }
}
