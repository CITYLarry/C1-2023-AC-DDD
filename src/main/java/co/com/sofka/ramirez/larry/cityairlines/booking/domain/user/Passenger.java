package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.PassengerData;

public class Passenger extends Entity<Identity> {

    private String seatId;
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

    protected void assignSeat(String seatId) {
        this.seatId = seatId;
    }

    public void updateSeat(String newSeatId) {
        if (seatId == null) {
            throw new IllegalStateException("The passenger has no assigned seat");
        }
        //TODO: database check unsigned seats
        this.seatId = newSeatId;
    }
}
