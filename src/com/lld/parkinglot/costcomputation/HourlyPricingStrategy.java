package com.lld.parkinglot.costcomputation;

import com.lld.parkinglot.Ticket;

public class HourlyPricingStrategy extends PricingStrategy {

    @Override
    public int price(Ticket ticket) {
        return (int)(calculateHours(ticket) * ticket.getParkingSpot().getPrice());
    }

    private double calculateHours(Ticket ticket) {
        int currTime=100; //100th minute
        return (currTime-ticket.getEntryTime())/60;
    }
}