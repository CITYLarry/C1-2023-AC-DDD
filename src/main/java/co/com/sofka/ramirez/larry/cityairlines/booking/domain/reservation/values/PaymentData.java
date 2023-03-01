package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

import java.sql.Timestamp;

public class PaymentData implements ValueObject<PaymentData.Props> {

    private final Timestamp date;
    private final String method;

    public PaymentData(Timestamp date, String method){
       this.date = date;
       this.method = method;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Timestamp date() {
                return date;
            }

            @Override
            public String method() {
                return method;
            }
        };
    }

    public interface Props{
        Timestamp date();
        String method();
    }
}
