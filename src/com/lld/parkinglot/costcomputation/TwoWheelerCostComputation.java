package com.lld.parkinglot.costcomputation;

public class TwoWheelerCostComputation extends CostComputation{

    TwoWheelerCostComputation(){
        super(new HourlyPricingStrategy());
    }
}
