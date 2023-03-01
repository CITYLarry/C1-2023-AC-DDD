package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Payment;

public class CreatedReservation extends DomainEvent {

    private final Identity userId;
    private final Flight flight;
    private final Payment payment;

    public CreatedReservation(Identity userId, Flight flight, Payment payment){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation");
        this.userId = userId;
        this.flight = flight;
        this.payment = payment;
    }

    public Identity userId(){
        return this.userId;
    }

    public Flight flight(){
        return flight;
    }

    public Payment payment(){
        return payment;
    }
}
