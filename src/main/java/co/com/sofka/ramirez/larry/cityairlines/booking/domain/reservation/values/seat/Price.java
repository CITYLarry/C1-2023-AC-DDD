package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class Price implements ValueObject<Integer> {

    private final Integer price;

    public Price(Integer price) {
        this.price = price;
    }

    @Override
    public Integer value() {
        return price;
    }
}
