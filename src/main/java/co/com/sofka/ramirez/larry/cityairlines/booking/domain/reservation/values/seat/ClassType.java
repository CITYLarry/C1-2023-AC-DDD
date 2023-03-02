package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class ClassType implements ValueObject<ClassType.SeatClass> {

    private SeatClass classType;

    public ClassType(SeatClass classType) {
        this.classType = classType;
    }

    @Override
    public SeatClass value() {
        return classType;
    }

    public enum SeatClass{
        ECONOMY,
        FIRST_CLASS
    }
}
