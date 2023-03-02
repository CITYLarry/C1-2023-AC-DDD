package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.AggregateRoot;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.entities.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.entities.Payment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.entities.Seat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;

import java.util.List;
import java.util.Map;

public class Reservation extends AggregateRoot<ReservationId> {

    protected Identity userId;
    protected Map<Identity, Seat> seats;
    protected Flight flight;
    protected Payment payment;

    public Reservation(ReservationId id, Identity userId, Flight flight, Payment payment){
        super(id);
        subscribe(new ReservationBehavior(this));
        appendChange(new CreatedReservation(userId, flight, payment));
    }


}
