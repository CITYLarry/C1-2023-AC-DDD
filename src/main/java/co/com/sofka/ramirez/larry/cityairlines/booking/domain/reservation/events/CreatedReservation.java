package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Payment;

public class CreatedReservation extends DomainEvent {

    private final Flight flight;
    private final Payment payment;

    public CreatedReservation(Flight flight, Payment payment){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation");
        this.flight = flight;
        this.payment = payment;
    }

    public Flight flight(){
        return flight;
    }

    public Payment payment(){
        return payment;
    }
}
