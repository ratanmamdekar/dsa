package com.lld.car.rental;

public class Bill {
    Reservation reservation;
    Double amount;
    Boolean isPaid;

    Bill(Reservation reservation){
        this.reservation = reservation;
        isPaid=false;
        amount = calculateBillAmount();
    }

    private Double calculateBillAmount() {
        Vehicle vehicle = reservation.vehicle;
        return vehicle.hourlyRentalCost * getDuration();
    }

    private double getDuration() {
        double hoursPerMs = 1000 * 60 * 60;
        return (reservation.bookingEnds.getTime() - reservation.bookingStart.getTime()) / hoursPerMs;
    }

}
