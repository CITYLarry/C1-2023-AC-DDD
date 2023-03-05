package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.ClassType;

public class AssignSeatCommand extends Command {

    private String seatId;
    private ClassType.SeatClass classType;
    private Integer price;
    private String passengerId;
    private String reservationId;

    private AssignSeatCommand() {}

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

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public ClassType.SeatClass getClassType() {
        return classType;
    }

    public void setClassType(ClassType.SeatClass classType) {
        this.classType = classType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
