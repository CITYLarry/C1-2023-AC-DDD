package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.BookingHistory;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.Luggage;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.Passenger;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserData;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.UserFacturationData;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateUserCommand extends Command {

    private final Identity id;
    private final UserFacturationData facturationData;
    private final UserData data;
    private final Set<Passenger> passengers;
    private final Identity bookingHistoryId;
    private final Map<Identity, Luggage> luggage;

    public CreateUserCommand(Identity id, UserFacturationData facturationData, UserData data){
        this.id = id;
        this.facturationData = facturationData;
        this.data = data;
        this.passengers = new HashSet<>();
        this.bookingHistoryId = new BookingHistory(new Identity()).identity();
        this.luggage = new HashMap<>();
    }

    public Identity id() {
        return id;
    }

    public UserFacturationData facturationData() {
        return facturationData;
    }

    public UserData data() {
        return data;
    }

    public Set<Passenger> passengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Identity bookingHistoryId(){
        return bookingHistoryId;
    }

    public Map<Identity, Luggage> luggage() {
        return luggage;
    }

    public void addLuggage(Identity passengerId, Luggage luggage) {
        this.luggage.put(passengerId, luggage);
    }
}
