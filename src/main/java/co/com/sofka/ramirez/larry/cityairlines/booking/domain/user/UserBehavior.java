package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.EventChange;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.BookingHistory;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.Passenger;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedPassenger;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.BookingHistoryId;

import java.util.HashMap;
import java.util.HashSet;

public class UserBehavior extends EventChange {

    public UserBehavior(User user) {
        apply((CreatedUser event) -> {
           user.userName = event.userName();
           user.password = event.password();
           user.userEmail = event.userEmail();
           user.address = event.address();
           user.passengerSet = new HashSet<>();
           user.bookingHistory = BookingHistory.from(new BookingHistoryId());
           user.luggageMap =  new HashMap<>();
        });

        apply((AddedPassenger event) -> {
            Passenger passenger = Passenger.from(event.passengerId(), event.passengerName(), event.idNum(), event.passengerEmail());
            user.passengerSet.add(passenger);
        });
    }
}
