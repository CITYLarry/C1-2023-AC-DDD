package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.Identity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BookingHistory extends Entity<Identity> {

    //TODO: Replace String with Reservation object
    private final Set<String> reservations;

    public BookingHistory(Identity id) {
        super(id);
        this.reservations = new HashSet<>();
    }

    //TODO: Replace String with Reservation object
    protected void addReservation(String reservation) {
        this.reservations.add(reservation);
    }

    //TODO: Replace String with Reservation object
    //TODO: edit filter r -> r.equals(reservationId)
    protected Optional<String> findReservation(Identity reservationId) {
        return this.reservations.stream()
                .filter(r -> false)
                .findFirst();
    }

    //TODO: Replace String with Reservation object
    protected Set<String> getHistory() {
        return reservations;
    }
}
