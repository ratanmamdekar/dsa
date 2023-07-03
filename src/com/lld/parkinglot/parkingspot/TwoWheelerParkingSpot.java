package com.lld.parkinglot.parkingspot;

import com.lld.parkinglot.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot{

    static int PRICE_FOR_TWO_WHEELER_PARKING = 10;

    TwoWheelerParkingSpot(int id) {
        super(id, PRICE_FOR_TWO_WHEELER_PARKING, VehicleType.TWO_WHEELER);
    }
}
