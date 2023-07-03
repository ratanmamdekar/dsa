package com.lld.parkinglot;

import com.lld.parkinglot.parkingspot.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ticket {
    String id;
    int entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
}
