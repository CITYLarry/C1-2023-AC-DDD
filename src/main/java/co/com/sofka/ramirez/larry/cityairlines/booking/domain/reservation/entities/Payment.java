package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.PaymentId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentDate;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentMethod;

public class Payment extends Entity<PaymentId> {

    private PaymentDate paymentDate;
    private PaymentMethod paymentMethod;

    private Payment(PaymentId paymentId) {
        super(paymentId);
    }

    private Payment(PaymentId paymentId,PaymentDate paymentDate, PaymentMethod paymentMethod) {
        super(paymentId);
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public static Payment from(PaymentId paymentId,PaymentDate paymentDate, PaymentMethod paymentMethod) {
        return new Payment(paymentId, paymentDate, paymentMethod);
    }

    public PaymentDate paymentDate() {
        return paymentDate;
    }

    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }
}
