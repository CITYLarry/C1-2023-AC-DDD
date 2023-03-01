package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.EventChange;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;

import java.util.HashMap;
import java.util.HashSet;

public class UserBehavior extends EventChange {

    public UserBehavior(User user) {
        apply((CreatedUser event) -> {
           user.facturationData = event.facturationData();
           user.data = event.data();
           user.passengers = new HashSet<>();
           user.bookingHistory = new BookingHistory(new Identity());
           user.luggage = new HashMap<>();
        });
    }
}
