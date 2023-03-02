package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.AggregateRoot;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Payment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Seat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;

import java.util.Map;

public class Reservation extends AggregateRoot<ReservationId> {

    protected UserId userId;
    protected Map<PassengerId, Seat> seats;
    protected Flight flight;
    protected Payment payment;

    private Reservation(ReservationId reservationId){
        super(reservationId);
        subscribe(new ReservationBehavior(this));
    }

    public Reservation(ReservationId id, UserId userId, Flight flight, Payment payment){
        super(id);
        subscribe(new ReservationBehavior(this));
        appendChange(new CreatedReservation(userId,flight, payment)).apply();
    }


}
