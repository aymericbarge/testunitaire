package com.testunitaire;

import java.util.ArrayList;

public class Parking {
    private int capaciteMaxParking = 1000;
    private int nbPplacesDispo;
    private ArrayList<String> vehiculeAutorises;
    private ArrayList<String> vehiculeStationnees;

    public ArrayList<String> getVehiculeStationnees() {
        return vehiculeStationnees;
    }

    public void setVehiculeStationnees(ArrayList<String> vehiculeStationnees) {
        this.vehiculeStationnees = vehiculeStationnees;
    }

    public Parking() {

    }

    public Parking(int capacite) {
        capaciteMaxParking = capacite;
        vehiculeAutorises = new ArrayList<String>();
        vehiculeStationnees = new ArrayList<String>();
    }

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
        if (vehiculeAutorises.contains(immatriculation)) {
            vehiculeStationnees.add(immatriculation);
            return true;
        }
        return false;
    }

    public boolean enregistrerSortieVehicule(String immatriculation) {
        if (vehiculeAutorises.contains(immatriculation)) {
            vehiculeStationnees.remove(immatriculation);
            return true;
        }
        return false;
    }

    public boolean rechercherVehiculeParking(String immatriculation) {
        if (vehiculeStationnees.contains(immatriculation)) {

            return true;
        }
        return false;
    }

    public int getNombreVehiculeStationnes() {
        return vehiculeStationnees.size();

    }

    public boolean parkingPlein() {
        if (getNombreVehiculeStationnes() > capaciteMaxParking) {
            return false;
        }
        return true;

    }

    public void affichageVehiculeStationnes() {
        vehiculeStationnees.toString();
    }
}