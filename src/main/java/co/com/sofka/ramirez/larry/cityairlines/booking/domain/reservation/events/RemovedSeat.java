package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;

public class RemovedSeat extends DomainEvent {

    private PassengerId  passengerId;

    public RemovedSeat() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.RemovedSeat");
    }

    public RemovedSeat(PassengerId passengerId) {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.RemovedSeat");
        this.passengerId = passengerId;
    }

    public PassengerId passengerId() {
        return passengerId;
    }
}
