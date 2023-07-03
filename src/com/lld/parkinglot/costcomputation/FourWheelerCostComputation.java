package com.lld.parkinglot.costcomputation;

public class FourWheelerCostComputation extends CostComputation{

    FourWheelerCostComputation(){
        super(new MinutelyPricingStrategy());
    }
}
