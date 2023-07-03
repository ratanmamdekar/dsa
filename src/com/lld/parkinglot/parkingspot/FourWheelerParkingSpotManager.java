package com.lld.parkinglot.parkingspot;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager {

    FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots,new NearToEntranceParkingStrategy());
    }

    @Override
    public ParkingSpot findParkingSpot() {
        return parkingStrategy.find();
    }
}
