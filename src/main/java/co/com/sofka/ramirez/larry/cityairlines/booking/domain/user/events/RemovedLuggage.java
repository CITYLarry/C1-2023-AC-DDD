package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;

public class RemovedLuggage extends DomainEvent {

    private PassengerId passengerId;

    private RemovedLuggage() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.RemovedLuggage");
    }

    public RemovedLuggage(PassengerId passengerId){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.RemovedLuggage");
        this.passengerId = passengerId;
    }

    public PassengerId passengerId() {
        return passengerId;
    }
}
