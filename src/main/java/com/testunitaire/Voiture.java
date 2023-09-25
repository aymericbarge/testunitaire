package com.testunitaire;

public class Voiture {
    private String immatriculation;

    public Voiture(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void changerImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getImmatriculation() {
        return this.immatriculation;
    }

}
