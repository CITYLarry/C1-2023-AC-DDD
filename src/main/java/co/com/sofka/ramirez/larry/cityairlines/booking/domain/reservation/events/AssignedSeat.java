package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Seat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;

public class AssignedSeat extends DomainEvent {

    private PassengerId passengerId;
    private Seat seat;

    public AssignedSeat() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.AssignedSeat");
    }

    public AssignedSeat(PassengerId passengerId, Seat seat) {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.AssignedSeat");
        this.passengerId = passengerId;
        this.seat = seat;
    }

    public PassengerId passengerId() {
        return passengerId;
    }

    public Seat seat() {
        return seat;
    }
}
