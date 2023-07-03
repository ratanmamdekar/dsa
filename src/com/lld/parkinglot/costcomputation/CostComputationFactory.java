package com.lld.parkinglot.costcomputation;

import com.lld.parkinglot.Ticket;
import com.lld.parkinglot.VehicleType;

public class CostComputationFactory {

    public static CostComputation getCostComputation(Ticket ticket){
        if(VehicleType.TWO_WHEELER.equals(ticket.getVehicle().getVehicleType())){
            return new TwoWheelerCostComputation();
        }
        else {
            return new FourWheelerCostComputation();
        }
    }
}
