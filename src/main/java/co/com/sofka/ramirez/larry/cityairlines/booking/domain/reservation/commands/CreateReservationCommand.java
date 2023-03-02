package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;

public class CreateReservationCommand extends Command {

    private String reservationId;
    private String userId;

    public CreateReservationCommand(){}

    public CreateReservationCommand(String reservationId, String userId){
        this.reservationId = reservationId;
        this.userId = userId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
