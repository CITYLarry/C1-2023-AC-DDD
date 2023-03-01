package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.IdNum;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerName;

public class AddedPassenger extends DomainEvent {

    private PassengerId passengerId;
    private PassengerName passengerName;
    private PassengerEmail passengerEmail;
    private IdNum idNum;

    public AddedPassenger(){
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedPassenger");
    }

    public AddedPassenger(PassengerId passengerId, PassengerName passengerName, PassengerEmail passengerEmail, IdNum idNum) {
        super("co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedPassenger");
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;
        this.idNum = idNum;
    }

    public PassengerId passengerId(){
        return passengerId;
    }

    public PassengerName passengerName() {
        return passengerName;
    }

    public PassengerEmail passengerEmail() {
        return passengerEmail;
    }

    public IdNum idNum() {
        return idNum;
    }
}
