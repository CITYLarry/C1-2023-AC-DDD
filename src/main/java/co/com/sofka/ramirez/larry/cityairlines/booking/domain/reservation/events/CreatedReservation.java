package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Payment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;

public class CreatedReservation extends DomainEvent {

    private UserId userId;
    private Flight flight;
    private Payment payment;

    public CreatedReservation() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation");
    }

    public CreatedReservation(UserId userId,Flight flight, Payment payment){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation");
        this.userId = userId;
        this.flight = flight;
        this.payment = payment;
    }

    public UserId userId(){
        return userId;
    }

    public Flight flight(){
        return flight;
    }

    public Payment payment(){
        return payment;
    }
}
