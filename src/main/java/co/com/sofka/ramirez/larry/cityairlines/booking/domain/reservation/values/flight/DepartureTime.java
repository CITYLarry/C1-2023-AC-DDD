package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

import java.time.Instant;

public class DepartureTime implements ValueObject<Instant> {

    private final Instant departureTime;

    public DepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public Instant value() {
        return departureTime;
    }
}
