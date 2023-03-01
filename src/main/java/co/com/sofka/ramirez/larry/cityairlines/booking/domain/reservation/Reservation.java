package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.AggregateRoot;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;

import java.util.List;
import java.util.Map;

public class Reservation extends AggregateRoot<Identity> {

    protected Identity userId;
    protected Map<Identity, Seat> seats;
    protected Flight flight;
    protected Payment payment;

    public Reservation(Identity id, Identity userId, Flight flight, Payment payment){
        super(id);
        subscribe(new ReservationBehavior(this));
        appendChange(new CreatedReservation(userId, flight, payment));
    }

    public void updateSeatIsAvailable(Seat seat, Boolean available) {
        seat.updateIsAvailable(available);
    }

    public void updateFlightAvailableSeats(List<String> availableSeats) {
        flight.updateAvailableSeats(availableSeats);
    }

    public boolean validatePayment(){
        return payment.validate();
    }

    public void emitTicket(Reservation reservation){
        System.out.println(reservation.toString());
    }
}
