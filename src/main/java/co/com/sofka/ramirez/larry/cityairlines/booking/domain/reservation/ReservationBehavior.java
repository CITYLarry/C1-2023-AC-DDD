package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.EventChange;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;

import java.util.HashMap;

public class ReservationBehavior extends EventChange {

    public ReservationBehavior(Reservation reservation){

        apply((CreatedReservation event) -> {
            reservation.userId = event.userId();
            reservation.seats = new HashMap<>();
            reservation.flight = event.flight();
            reservation.payment = event.payment();
        });

    }
}
