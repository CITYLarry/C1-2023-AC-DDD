package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

import java.time.Instant;

public class ArrivalTime implements ValueObject<Instant> {

    private final Instant arrivalTime;

    public ArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public Instant value() {
        return arrivalTime;
    }
}
