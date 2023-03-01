package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.PaymentData;

public class Payment extends Entity<Identity> {

    private String status;
    private Integer amount;
    private PaymentData data;

    public Payment(Identity id, String status, Integer amount, PaymentData data) {
        super(id);
        this.status = status;
        this.amount = amount;
        this.data = data;
    }

    public String status() {
        return status;
    }

    public Integer amount() {
        return amount;
    }

    public PaymentData data() {
        return data;
    }

    public Boolean validate() {
        return false;
    }
}
