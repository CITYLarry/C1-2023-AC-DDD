package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class PaymentId extends Identity {

    private PaymentId(String uuid) {
        super(uuid);
    }

    public PaymentId(){}

    public static PaymentId of(String uuid) {
        return new PaymentId(uuid);
    }
}
