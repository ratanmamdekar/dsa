package com.lld.parkinglot.costcomputation;

import com.lld.parkinglot.Ticket;

public class MinutelyPricingStrategy extends PricingStrategy {

    @Override
    public int price(Ticket ticket) {
        return calculateMinutes(ticket) * ticket.getParkingSpot().getPrice();
    }

    private int calculateMinutes(Ticket ticket) {
        int currTime=100; //100th minute
        return currTime-ticket.getEntryTime();
    }
}