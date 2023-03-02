package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class DepartureAirport implements ValueObject<String> {

    private final String departureAirport;

    public DepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    @Override
    public String value() {
        return departureAirport;
    }
}
