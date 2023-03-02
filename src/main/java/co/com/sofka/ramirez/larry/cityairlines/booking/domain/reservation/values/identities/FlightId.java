package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class FlightId extends Identity {

    private FlightId(String uuid) {
        super(uuid);
    }

    public FlightId(){}

    public static FlightId of(String uuid) {
        return new FlightId(uuid);
    }
}
