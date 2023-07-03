package com.lld.parkinglot.costcomputation;

import com.lld.parkinglot.Ticket;

public class CostComputation {
    private PricingStrategy pricingStrategy;

    CostComputation (PricingStrategy pricingStrategy){
        this.pricingStrategy=pricingStrategy;
    }

    public int calculatePrice(Ticket ticket){
        return pricingStrategy.price(ticket);
    }
}
