package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Reservation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BookingHistory extends Entity<Identity> {

    private final Set<Reservation> reservations;

    public BookingHistory(Identity id) {
        super(id);
        this.reservations = new HashSet<>();
    }

    protected void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    protected Optional<Reservation> findReservation(Identity reservationId) {
        return this.reservations.stream()
                .filter(r -> false)
                .findFirst();
    }

    protected Set<Reservation> getHistory() {
        return reservations;
    }
}
