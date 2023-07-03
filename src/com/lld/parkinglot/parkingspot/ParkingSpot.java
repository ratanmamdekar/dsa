package com.lld.parkinglot.parkingspot;

import com.lld.parkinglot.Vehicle;
import com.lld.parkinglot.VehicleType;
import lombok.Getter;

@Getter
public abstract class ParkingSpot {
    int id;
    boolean isEmpty;
    Vehicle vehicle;
    int price;
    VehicleType parkingType;

    ParkingSpot(int id, int price, VehicleType type){
        this.id = id;
        this.price = price;
        this.parkingType = type;
        this.isEmpty=true;
    }

    void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    void removeVehicle(){
        this.vehicle = null;
        this.isEmpty = true;
    }
}
