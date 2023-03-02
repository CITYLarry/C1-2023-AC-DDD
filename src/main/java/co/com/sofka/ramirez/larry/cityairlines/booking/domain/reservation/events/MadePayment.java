package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.PaymentId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentDate;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentMethod;

public class MadePayment extends DomainEvent {

    private PaymentId paymentId;
    private PaymentMethod paymentMethod;
    private PaymentDate paymentDate;

    private MadePayment() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.MadePayment");
    }

    public MadePayment(PaymentId paymentId, PaymentMethod paymentMethod, PaymentDate paymentDate) {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.MadePayment");
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public PaymentId paymentId() {
        return paymentId;
    }

    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }

    public PaymentDate paymentDate() {
        return paymentDate;
    }
}
