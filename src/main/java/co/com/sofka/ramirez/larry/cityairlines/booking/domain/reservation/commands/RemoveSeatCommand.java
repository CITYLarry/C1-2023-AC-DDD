package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;

public class RemoveSeatCommand extends Command {

    private String passengerId;
    private String reservationId;

    public RemoveSeatCommand(){}

    public RemoveSeatCommand(String passengerId, String reservationId) {
        this.passengerId = passengerId;
        this.reservationId = reservationId;
    }

    public String passengerId() {
        return passengerId;
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
