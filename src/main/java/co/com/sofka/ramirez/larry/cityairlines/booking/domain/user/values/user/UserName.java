package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class UserName implements ValueObject<String> {

    private final String userName;

    public UserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String value() {
        return userName;
    }
}
