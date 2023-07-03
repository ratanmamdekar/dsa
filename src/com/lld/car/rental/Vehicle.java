package com.lld.car.rental;

import com.lld.parkinglot.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    int vehicleId;
    String vehicleNumber;
    VehicleType vehicleType;
    String companyName;
    String modelName;
    int kmDriven;
    int cc;
    int average;
    int noOfSeats;
    int dailyRentalCost;
    int hourlyRentalCost;
    Status status;

}
