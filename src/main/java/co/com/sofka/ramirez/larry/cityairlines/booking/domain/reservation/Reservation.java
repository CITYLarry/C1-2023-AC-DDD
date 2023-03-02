package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.AggregateRoot;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Payment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Seat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.AssignedSeat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.RemovedSeat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Reservation extends AggregateRoot<ReservationId> {

    protected UserId userId;
    protected Map<PassengerId, Seat> seatsMap;
    protected Flight flight;
    protected Payment payment;

    private Reservation(ReservationId reservationId){
        super(reservationId);
        subscribe(new ReservationBehavior(this));
    }

    public Reservation(ReservationId id, UserId userId){
        super(id);
        subscribe(new ReservationBehavior(this));
        appendChange(new CreatedReservation(userId)).apply();
    }

    public static Reservation from(ReservationId reservationId, List<DomainEvent> events){
        Reservation reservation = new Reservation(reservationId);
        events.forEach(reservation::applyEvent);
        return reservation;
    }

    public void assignSeat(PassengerId passengerId, Seat seat){
        Objects.requireNonNull(passengerId);
        Objects.requireNonNull(seat);
        appendChange(new AssignedSeat(passengerId, seat)).apply();
    }

    public void removeSeat(PassengerId passengerId){
        Objects.requireNonNull(passengerId);
        appendChange(new RemovedSeat(passengerId)).apply();
    }
}
