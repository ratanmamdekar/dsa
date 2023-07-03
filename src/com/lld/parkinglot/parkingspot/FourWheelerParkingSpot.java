package com.lld.parkinglot.parkingspot;

import com.lld.parkinglot.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot{

    static int PRICE_FOR_FOUR_WHEELER_PARKING = 30;

    FourWheelerParkingSpot(int id) {
        super(id, PRICE_FOR_FOUR_WHEELER_PARKING, VehicleType.FOUR_WHEELER);
    }
}
