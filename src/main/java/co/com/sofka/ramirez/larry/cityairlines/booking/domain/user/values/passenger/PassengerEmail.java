package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class PassengerEmail implements ValueObject<String> {

    private final String email;

    public PassengerEmail(String email) {
        this.email = email;
    }

    @Override
    public String value() {
        return email;
    }
}
