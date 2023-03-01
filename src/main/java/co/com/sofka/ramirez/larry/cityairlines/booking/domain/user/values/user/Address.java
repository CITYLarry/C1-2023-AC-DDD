package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class Address implements ValueObject<String> {

    private final String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String value() {
        return address;
    }
}
