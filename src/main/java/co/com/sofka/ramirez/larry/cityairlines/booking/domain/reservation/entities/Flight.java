package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.FlightId;

public class Flight extends Entity<FlightId> {

    private DepartureAirport departureAirport;
    private ArrivalAirport arrivalAirport;
    private DepartureTime departureTime;
    private ArrivalTime arrivalTime;

    private Flight(FlightId flightId) {
        super(flightId);
    }

    private Flight(FlightId flightId,
                   DepartureAirport departureAirport,
                   ArrivalAirport arrivalAirport,
                   DepartureTime departureTime,
                   ArrivalTime arrivalTime) {
        super(flightId);
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public static Flight from(FlightId flightId,
                              DepartureAirport departureAirport,
                              ArrivalAirport arrivalAirport,
                              DepartureTime departureTime,
                              ArrivalTime arrivalTime){
        return new Flight(flightId, departureAirport, arrivalAirport, departureTime, arrivalTime);
    }

    public DepartureAirport departureAirport() {
        return departureAirport;
    }

    public ArrivalAirport arrivalAirport() {
        return arrivalAirport;
    }

    public DepartureTime departureTime() {
        return departureTime;
    }

    public ArrivalTime arrivalTime() {
        return arrivalTime;
    }
}
