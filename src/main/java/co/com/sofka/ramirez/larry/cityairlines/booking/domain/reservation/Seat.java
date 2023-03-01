package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Entity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.SeatData;

public class Seat extends Entity<Identity> {

    private String number;
    private Boolean available;
    private SeatData data;

    public Seat(Identity id, String number, Boolean available, SeatData data){
        super(id);
        this.number = number;
        this.available = available;
        this.data = data;
    }

    public String number(){
        return number;
    }

    public Boolean isAvailable(){
        return available;
    }

    public SeatData getData(){
        return data;
    }

    public void updateIsAvailable(Boolean available){
        this.available = available;
    }
}
