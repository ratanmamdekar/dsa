package com.lld.parkinglot.parkingspot;

import com.lld.parkinglot.Vehicle;
import com.lld.parkinglot.VehicleType;

import java.util.ArrayList;

public class ParkingSlotManagerFactory {

    public static ParkingSpotManager getParkingSlotManager(Vehicle vehicle){
        if(VehicleType.TWO_WHEELER.equals(vehicle.getVehicleType()))
            return new TwoWheelerParkingSpotManager(new ArrayList<>());  //get from ParkingSpotUtil
        else
            return new FourWheelerParkingSpotManager(new ArrayList<>());  //get from ParkingSpotUtil
    }
}
