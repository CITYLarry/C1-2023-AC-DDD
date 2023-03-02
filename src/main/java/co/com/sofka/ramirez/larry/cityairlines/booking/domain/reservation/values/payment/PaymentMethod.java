package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class PaymentMethod implements ValueObject<String> {

    private final String paymentMethod;

    public PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String value() {
        return paymentMethod;
    }
}
