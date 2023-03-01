package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.IdNum;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerName;

public class Passenger extends Entity<PassengerId> {

    private PassengerName passengerName;
    private IdNum idNum;
    private PassengerEmail passengerEmail;

    private Passenger(PassengerId passengerId) {
        super(passengerId);
    }

    private Passenger(PassengerId passengerId,
                      PassengerName passengerName,
                      IdNum idNum,
                      PassengerEmail passengerEmail) {
        super(passengerId);
        this.passengerName = passengerName;
        this.idNum = idNum;
        this.passengerEmail = passengerEmail;
    }

    public static Passenger from(PassengerId passengerId,
                                 PassengerName passengerName,
                                 IdNum idNum,
                                 PassengerEmail passengerEmail){
        return new Passenger(passengerId, passengerName, idNum, passengerEmail);
    }

    public PassengerName passengerName() {
        return passengerName;
    }

    public IdNum idNum() {
        return idNum;
    }

    public PassengerEmail passengerEmail() {
        return passengerEmail;
    }
}
