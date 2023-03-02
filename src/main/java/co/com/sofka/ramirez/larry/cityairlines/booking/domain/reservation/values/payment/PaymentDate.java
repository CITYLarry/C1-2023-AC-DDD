package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

import java.time.Instant;

public class PaymentDate implements ValueObject<Instant> {

    private final Instant paymentDate;

    public PaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public Instant value() {
        return paymentDate;
    }
}
