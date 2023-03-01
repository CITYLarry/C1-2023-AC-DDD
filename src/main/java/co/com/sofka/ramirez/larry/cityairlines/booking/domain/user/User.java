package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.AggregateRoot;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserData;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserFacturationData;

import java.util.Map;
import java.util.Set;


public class User extends AggregateRoot<Identity> {

    protected UserFacturationData facturationData;
    protected UserData data;
    protected Set<Passenger> passengers;
    protected Identity bookingHistoryId;
    protected Map<Identity, Luggage> luggage;

    public User(Identity id, UserFacturationData facturationData, UserData data){
        super(id);
        appendChange(new CreatedUser(facturationData, data)).apply();
    }
}
