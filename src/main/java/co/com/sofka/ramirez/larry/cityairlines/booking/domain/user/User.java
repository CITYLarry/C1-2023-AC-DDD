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
    protected BookingHistory bookingHistory;
    protected Map<Identity, Luggage> luggage;

    public User(Identity id, UserFacturationData facturationData, UserData data){
        super(id);
        subscribe(new UserBehavior(this));
        appendChange(new CreatedUser(facturationData, data)).apply();
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public void assignPassengerSeat(Passenger passenger, String seat){
        passenger.assignSeat(seat);
    }

    public void updatePassengerSeat(Passenger passenger, String seat){
        passenger.updateSeat(seat);
    }

    //TODO: Replace String with object Reservation
    public void addBookingHistoryReservation(String reservation){
        bookingHistory.addReservation(reservation);
    }

    public void findBookingReservation(Identity reservationId){
        bookingHistory.findReservation(reservationId);
    }

    public Set<String> getBookingHistory(){
        return bookingHistory.getHistory();
    }

    public void addLuggage(Identity passengerId, Luggage luggage){
        this.luggage.put(passengerId, luggage);
    }

    public void removeLuggage(Identity passengerId){
        luggage.remove(passengerId);
    }

    public Map<Identity, Luggage> getAllLuggage(){
        return luggage;
    }

    public void updateLuggageType(Luggage luggage, Luggage.LuggageType type){
        luggage.updateType(type);
    }
}