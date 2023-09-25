package com.testunitaire;

import java.util.ArrayList;

public class Parking {
    private int capaciteMaxParking = 1000;
    private int nbPplacesDispo;
    private ArrayList<String> vehiculeAutorises;
    private ArrayList<String> vehiculeStationnees;

    public Parking() {

    };

    public Parking(int capacite) {
        capaciteMaxParking = capacite;
        vehiculeAutorises = new ArrayList<String>();
        vehiculeStationnees = new ArrayList<String>();
    };

    public ArrayList<String> getVehiculeAutorises() {
        return vehiculeAutorises;
    }

    public void setVehiculeAutorises(ArrayList<String> vehiculeAutorises) {
        this.vehiculeAutorises = vehiculeAutorises;
    }

    public int getTailleVehiculeAutorises() {
        return vehiculeAutorises.size();
    }

    public boolean ajouterVehiculeAutorises(String immatriculation) {
        if (!vehiculeAutorises.contains(immatriculation)) {
            vehiculeAutorises.add(immatriculation);
            return true;
        }
        return false;
    };

    public boolean ouverturePorteParking(String immatriculation) {
        if (vehiculeAutorises.contains(immatriculation))
            return true;
        return false;
    }

    public boolean enregistrerEntreeVehicule(String immatriculation) {
        if (!vehiculeAutorises.contains(immatriculation)) {
            vehiculeAutorises.add(immatriculation);
            return true;
        }
        return false;
    }
}
