package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class BookingHistoryId extends Identity {

    private BookingHistoryId(String uuid) {
        super(uuid);
    }

    public BookingHistoryId() {}

    public static BookingHistoryId of(String uuid) {
        return new BookingHistoryId(uuid);
    }
}
