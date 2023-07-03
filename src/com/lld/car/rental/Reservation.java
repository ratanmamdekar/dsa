package com.lld.car.rental;

import java.util.Date;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date bookingStart;
    Date bookingEnds;
    Location pickupLocation;
    Location dropLocation;
    ReservationStatus reservationStatus;

}
