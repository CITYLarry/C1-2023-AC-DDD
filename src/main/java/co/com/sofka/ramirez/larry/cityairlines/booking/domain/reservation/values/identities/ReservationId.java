package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class ReservationId extends Identity {

    private ReservationId(String uuid) {
        super(uuid);
    }

    public ReservationId(){}

    public static ReservationId of(String uuid){
        return new ReservationId(uuid);
    }
}
