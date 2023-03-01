package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.EventChange;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserData;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserFacturationData;

import java.util.HashMap;
import java.util.HashSet;

public class UserBehavior extends EventChange {

    public UserBehavior(User user) {
        apply((CreatedUser event) -> {
           user.facturationData = new UserFacturationData(
                   event.facturationData().value().street(),
                   event.facturationData().value().city(),
                   event.facturationData().value().country(),
                   event.facturationData().value().zipCode()
           );
           user.data = new UserData(
                   event.data().value().name(),
                   event.data().value().email(),
                   event.data().value().password()
           );
           user.passengers = new HashSet<>();
           user.bookingHistory = new BookingHistory(new Identity());
           user.luggage = new HashMap<>();
        });
    }
}
