package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class Password implements ValueObject<String> {

    private final String password;

    public Password(String password) {
        this.password = password;
    }

    @Override
    public String value() {
        return password;
    }
}
