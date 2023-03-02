package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.SeatId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.ClassType;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.Price;

public class Seat extends Entity<SeatId> {

    private ClassType classType;
    private Price price;

    private Seat(SeatId seatId) {
        super(seatId);
    }

    private Seat(SeatId seatId, ClassType type, Price price) {
        super(seatId);
        this.classType = type;
        this.price = price;
    }

    public static Seat from(SeatId seatId, ClassType type, Price price) {
        return new Seat(seatId, type, price);
    }

}
