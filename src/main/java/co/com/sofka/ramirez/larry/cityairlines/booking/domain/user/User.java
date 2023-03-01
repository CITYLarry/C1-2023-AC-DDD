package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.AggregateRoot;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.BookingHistory;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.Luggage;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.Passenger;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Address;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Password;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserName;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User extends AggregateRoot<UserId> {

    protected UserName userName;
    protected Password password;
    protected UserEmail userEmail;
    protected Address address;
    protected Set<Passenger> passengerSet;
    protected BookingHistory bookingHistory;
    protected Map<PassengerId, Luggage> luggageMap;


    private User(UserId userId){
        super(userId);
        subscribe(new UserBehavior(this));
    }

    public User(UserId userId, UserName userName, Password password, UserEmail userEmail, Address address) {
        super(userId);
        subscribe(new UserBehavior(this));
        appendChange(new CreatedUser(userName, password, userEmail, address));
    }

    public static User from(UserId userId, List<DomainEvent> events) {
        User user = new User(userId);
        events.forEach(user::applyEvent);
        return user;
    }
}
