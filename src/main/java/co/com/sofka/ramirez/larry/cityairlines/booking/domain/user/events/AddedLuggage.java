package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.Luggage;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.LuggageId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;

public class AddedLuggage extends DomainEvent {

    private LuggageId luggageId;
    private Luggage.LuggageType type;
    private PassengerId passengerId;

    private AddedLuggage() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedLuggage");
    }

    public AddedLuggage(LuggageId luggageId, Luggage.LuggageType type, PassengerId passengerId) {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedLuggage");
        this.luggageId = luggageId;
        this.type = type;
        this.passengerId = passengerId;
    }

    public LuggageId luggageId() {
        return luggageId;
    }

    public Luggage.LuggageType type() {
        return type;
    }

    public PassengerId passengerId() {
        return passengerId;
    }
}
