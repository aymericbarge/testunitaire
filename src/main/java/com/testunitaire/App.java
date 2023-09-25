package com.testunitaire;

public class App {

    public static void main(String[] args) {
        Voiture voiture1 = new Voiture("ABC-123");
        voiture1.changerImmatriculation("DCE-456");
        // System.out.println(getImmatriculation(voiture1));
        Parking parking1 = new Parking(500);
        parking1.ajouterVehiculeAutorises("DCE-456");
    }

}
