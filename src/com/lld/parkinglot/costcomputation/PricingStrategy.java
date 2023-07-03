package com.lld.parkinglot.costcomputation;

import com.lld.parkinglot.Ticket;

public class PricingStrategy {

    public int price(Ticket ticket){
        return ticket.getParkingSpot().getPrice();
    }
}
