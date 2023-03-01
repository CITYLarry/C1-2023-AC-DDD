package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.LuggageId;

public class Luggage extends Entity<LuggageId> {

    private LuggageType type;

    private Luggage(LuggageId luggageId) {
        super(luggageId);
    }

    private Luggage(LuggageId luggageId, LuggageType type) {
        super(luggageId);
        this.type = type;
    }

    public static Luggage from(LuggageId luggageId, LuggageType type) {
        return new Luggage(luggageId, type);
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
