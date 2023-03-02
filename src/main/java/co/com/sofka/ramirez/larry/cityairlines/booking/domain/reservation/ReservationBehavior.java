package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.EventChange;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Payment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.AssignedSeat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.BookedFlight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.MadePayment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.RemovedSeat;

import java.util.HashMap;

public class ReservationBehavior extends EventChange {

    public ReservationBehavior(Reservation reservation){

        apply((CreatedReservation event) -> {
            reservation.userId = event.userId();
            reservation.seatsMap = new HashMap<>();
        });

        apply((AssignedSeat event) -> {
            reservation.seatsMap.put(event.passengerId(), event.seat());
        });

        apply((RemovedSeat event) -> {
           reservation.seatsMap.remove(event.passengerId());
        });

        apply((BookedFlight event) -> {
            reservation.flight = Flight.from(
                    event.flightId(),
                    event.departureAirport(),
                    event.arrivalAirport(),
                    event.departureTime(),
                    event.arrivalTime()
            );
        });

        apply((MadePayment event) -> {
            reservation.payment = Payment.from(
                    event.paymentId(),
                    event.paymentDate(),
                    event.paymentMethod()
            );
        });
    }
}
