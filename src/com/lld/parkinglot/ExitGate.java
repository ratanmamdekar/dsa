package com.lld.parkinglot;

import com.lld.parkinglot.costcomputation.CostComputation;
import com.lld.parkinglot.costcomputation.CostComputationFactory;
import com.lld.parkinglot.parkingspot.ParkingSpotManager;
import com.lld.parkinglot.parkingspot.ParkingSlotManagerFactory;

public class ExitGate {

    CostComputation costComputation;
    ParkingSpotManager parkingSpotManager;

    public void makePayment(Ticket ticket){
        int paymentRequired = calculatePayment(ticket);
        System.out.println("please pay +" + paymentRequired + " in cash!");
    }

    public int calculatePayment(Ticket ticket){
        costComputation = CostComputationFactory.getCostComputation(ticket);
        return costComputation.calculatePrice(ticket);
    }

    public void freeParkingSpace(Ticket ticket){
        parkingSpotManager = ParkingSlotManagerFactory.getParkingSlotManager(ticket.getVehicle());
        parkingSpotManager.removeVehicle(ticket.getParkingSpot());
    }

}
