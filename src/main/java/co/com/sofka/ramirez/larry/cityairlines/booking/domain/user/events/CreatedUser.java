package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Address;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Password;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserName;


public class CreatedUser extends DomainEvent {

    private UserName userName;
    private Password password;
    private UserEmail userEmail;
    private Address address;

    private CreatedUser() {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser");
    }

    public CreatedUser(UserName userName, Password password, UserEmail userEmail, Address address){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser");
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
        this.address = address;
    }

    public UserName userName() {
        return userName;
    }

    public Password password() {
        return password;
    }

    public UserEmail userEmail() {
        return userEmail;
    }

    public Address address() {
        return address;
    }
}
