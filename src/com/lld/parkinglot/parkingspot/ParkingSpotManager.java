package com.lld.parkinglot.parkingspot;

import com.lld.parkinglot.Vehicle;

import java.util.List;

public abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;
    ParkingStrategy parkingStrategy;

    ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy){
        this.parkingSpots=parkingSpots;
        this.parkingStrategy=parkingStrategy;
    }

    public abstract ParkingSpot findParkingSpot();

    void addParkingSpot(){}

    void removeParkingSpot(){}

    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpot.parkVehicle(vehicle);
    }

    public void removeVehicle(ParkingSpot parkingSpot){
        parkingSpot.removeVehicle();
    }
}
