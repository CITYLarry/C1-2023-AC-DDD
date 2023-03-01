package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class IdNum implements ValueObject {

    private final String idNum;

    public IdNum(String idNum) {
        this.idNum = idNum;
    }

    @Override
    public String value() {
        return idNum;
    }
}
