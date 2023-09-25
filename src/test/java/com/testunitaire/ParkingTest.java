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
        Voiture vehicule = new Voiture("ABC-123");

        // Act
        parking.enregistrerEntreeVehicule("ABC-123");

        // Assert
        assertEquals(1, parking.getTailleVehiculeAutorises());
    }

    @Test
    public void voidcontexte_methodeSousTest_resulat() {
        // Arrange
        Parking parking = new Parking(1);
        Voiture vehicule = new Voiture("ABC-123");

        // Act
        parking.enregistrerEntreeVehicule("ABC-123");

        // Assert
        assertEquals(1, parking.getTailleVehiculeAutorises());
    }
}
