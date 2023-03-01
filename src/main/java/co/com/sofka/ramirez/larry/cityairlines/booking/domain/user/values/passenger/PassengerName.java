package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class PassengerName implements ValueObject<String> {

    private final String name;

    public PassengerName(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }
}
