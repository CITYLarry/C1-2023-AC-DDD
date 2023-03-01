package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class LuggageId extends Identity {

    private LuggageId(String uuid) {
        super(uuid);
    }

    public LuggageId() {}

    public static LuggageId of(String uuid) {
        return new LuggageId(uuid);
    }
}

