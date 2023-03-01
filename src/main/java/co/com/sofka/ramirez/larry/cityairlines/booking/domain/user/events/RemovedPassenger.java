package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;

public class RemovedPassenger extends DomainEvent {

    private PassengerId passengerId;

    private RemovedPassenger() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.RemovedPassanger");
    }

    public RemovedPassenger(PassengerId passengerId){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.RemovedPassanger");
        this.passengerId = passengerId;
    }

    public PassengerId passengerId() {
        return passengerId;
    }
}
