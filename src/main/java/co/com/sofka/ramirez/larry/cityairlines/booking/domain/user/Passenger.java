package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.PassengerData;

public class Passenger extends Entity<Identity> {

    private final String seatId;
    private final PassengerData data;

    public Passenger(Identity id, String seatId, PassengerData data) {
        super(id);
        this.seatId = seatId;
        this.data = data;
    }

    public String seatId() {
        return seatId;
    }

    public PassengerData data() {
        return data;
    }
}
