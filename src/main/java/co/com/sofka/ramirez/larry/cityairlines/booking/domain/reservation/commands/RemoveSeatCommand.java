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

    public String reservationId() {
        return reservationId;
    }
}
