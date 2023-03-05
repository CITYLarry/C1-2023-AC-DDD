package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Payment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;

public class CreatedReservation extends DomainEvent {

    private UserId userId;

    private CreatedReservation() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation");
    }

    public CreatedReservation(UserId userId){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation");
        this.userId = userId;
    }

    public UserId userId(){
        return userId;
    }
}
