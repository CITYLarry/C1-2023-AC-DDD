package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Identity;

public class Luggage extends Entity<Identity> {

    private LuggageType type;

    public Luggage(Identity id, LuggageType type) {
        super(id);
        this.type = type;
    }

    public LuggageType type() {
        return type;
    }

    public void updateType(LuggageType type) {
        this.type = type;
    }

    public enum LuggageType {
        PERSONAL,
        CABIN,
        HOLD
    }
}
