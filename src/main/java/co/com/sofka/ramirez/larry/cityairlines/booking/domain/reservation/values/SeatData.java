package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class SeatData implements ValueObject<SeatData.Props> {

    private final String classType;
    private final Integer price;

    public SeatData(String classType, Integer price) {
        this.classType = classType;
        this.price = price;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String classType() {
                return classType;
            }

            @Override
            public Integer price() {
                return price;
            }
        };
    }

    public interface Props {
        String classType();
        Integer price();
    }
}
