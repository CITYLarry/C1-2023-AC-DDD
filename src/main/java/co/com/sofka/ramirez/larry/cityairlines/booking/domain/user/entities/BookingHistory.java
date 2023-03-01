package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Reservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.BookingHistoryId;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BookingHistory extends Entity<BookingHistoryId> {

    private final Set<Reservation> reservations;


    private BookingHistory(BookingHistoryId bookingHistoryId) {
        super(bookingHistoryId);
        this.reservations = new HashSet<>();
    }

    public static BookingHistory from(BookingHistoryId bookingHistoryId) {
        return new BookingHistory(bookingHistoryId);
    }

    protected void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    protected Optional<Reservation> findReservation(ReservationId reservationId) {
        return this.reservations.stream()
                .filter(r -> r.identity().equals(reservationId))
                .findFirst();
    }

    protected Set<Reservation> getHistory() {
        return reservations;
    }
}
