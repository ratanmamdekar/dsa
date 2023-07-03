package com.lld.parkinglot;

import com.lld.parkinglot.parkingspot.ParkingSpotManager;
import com.lld.parkinglot.parkingspot.ParkingSlotManagerFactory;
import com.lld.parkinglot.parkingspot.ParkingSpot;

import java.util.UUID;

public class EntranceGate {
    ParkingSpotManager parkingSpotManager;

    ParkingSpot findParkingSpot(Vehicle vehicle, int gateNumber){
        parkingSpotManager = ParkingSlotManagerFactory.getParkingSlotManager(vehicle);
        return parkingSpotManager.findParkingSpot();
    }

    void ParkVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpotManager = ParkingSlotManagerFactory.getParkingSlotManager(vehicle);
        parkingSpotManager.parkVehicle(vehicle, parkingSpot);
    }

    Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot, int entryTime){
        return new Ticket(UUID.randomUUID().toString(), entryTime, vehicle, parkingSpot);
    }
}
