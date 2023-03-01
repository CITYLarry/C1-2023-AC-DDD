package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class UserId extends Identity {

    private UserId(String uuid) {
        super(uuid);
    }

    public UserId() {}

    public static UserId of(String uuid) {
        return new UserId(uuid);
    }
}
