package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserData;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserFacturationData;


public class CreatedUser extends DomainEvent {

    private final UserFacturationData facturationData;
    private final UserData data;

    public CreatedUser(UserFacturationData facturationData, UserData data){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.UserCreated");
        this.facturationData = facturationData;
        this.data = data;
    }

    public UserFacturationData facturationData(){
        return facturationData;
    }

    public UserData data(){
        return data;
    }
}
