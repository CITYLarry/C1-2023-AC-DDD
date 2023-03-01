package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.FlightAirportData;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.FlightTimeData;

import java.util.ArrayList;
import java.util.List;

public class Flight extends Entity<Identity> {

    private FlightTimeData timeData;
    private FlightAirportData airportData;
    private List<String> availableSeats;

    public Flight(Identity id, FlightTimeData timeData, FlightAirportData airportData) {
        super(id);
        this.timeData = timeData;
        this.airportData = airportData;
        this.availableSeats = new ArrayList<>();
    }

    public FlightTimeData timeData() {
        return timeData;
    }

    public FlightAirportData airportData() {
        return airportData;
    }

    public void updateAvailableSeats(List<String> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
