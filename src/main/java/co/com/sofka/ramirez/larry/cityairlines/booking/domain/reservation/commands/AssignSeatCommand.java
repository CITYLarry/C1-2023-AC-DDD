package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.ClassType;

public class AssignSeatCommand extends Command {

    private String seatId;
    private ClassType.SeatClass classType;
    private Integer price;
    private String passengerId;
    private String reservationId;

    public AssignSeatCommand() {}

    public AssignSeatCommand(String seatId, ClassType.SeatClass classType, Integer price, String passengerId, String reservationId) {
        this.seatId = seatId;
        this.classType = classType;
        this.price = price;
        this.passengerId = passengerId;
        this.reservationId = reservationId;
    }

    public String getSeatId() {
        return seatId;
    }

    public ClassType.SeatClass classType() {
        return classType;
    }

    public Integer price() {
        return price;
    }

    public String passengerId() {
        return passengerId;
    }

    public String reservationId() {
        return reservationId;
    }
}
