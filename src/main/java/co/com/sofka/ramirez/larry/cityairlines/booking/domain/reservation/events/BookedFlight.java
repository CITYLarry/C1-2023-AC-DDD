package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.FlightId;

public class BookedFlight extends DomainEvent {

    private FlightId flightId;
    private DepartureAirport departureAirport;
    private ArrivalAirport arrivalAirport;
    private DepartureTime departureTime;
    private ArrivalTime arrivalTime;

    private BookedFlight() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.BookedFlight");
    }

    public BookedFlight(FlightId flightId, DepartureAirport departureAirport, ArrivalAirport arrivalAirport, DepartureTime departureTime, ArrivalTime arrivalTime) {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.BookedFlight");
        this.flightId = flightId;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public FlightId flightId() {
        return flightId;
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
