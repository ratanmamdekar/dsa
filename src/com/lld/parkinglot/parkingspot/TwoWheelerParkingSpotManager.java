package com.lld.parkinglot.parkingspot;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {

    TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots,new NearToElevatorParkingStrategy());
    }

    @Override
    public ParkingSpot findParkingSpot() {
        return parkingStrategy.find();
    }
}
