package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class PassengerId extends Identity {

    private PassengerId(String uuid) {
        super(uuid);
    }

    public PassengerId() {}

    public static PassengerId of(String uuid) {
        return new PassengerId(uuid);
    }
}
