package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class SeatId extends Identity {

    private SeatId(String uuid) {
        super(uuid);
    }

    public SeatId(){}

    public static SeatId of(String uuid){
        return new SeatId(uuid);
    }
}
