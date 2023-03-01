package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class UserEmail implements ValueObject<String> {

    private final String userEmail;

    public UserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String value() {
        return userEmail;
    }
}
